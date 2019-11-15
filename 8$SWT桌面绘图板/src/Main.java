import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.imageio.ImageIO;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import com.wang.Win1.all.FiveStar;
import com.wang.Win1.depend.*;
import com.wang.Win1.utils.*;
import org.eclipse.swt.events.KeyAdapter;

public class Main {
	private int startX;
	private int startY;
	protected Shell shell;
	private static boolean leftButtonDown = false;
	private static int lastWidth;
	private static int lastHeight;
	private static String shapeType = "Circle";

	/**
	 * Launch the application.
	 * @param args
	 */
	public static GC gcMain = null;
	public static void main(String[] args) {
		try {
			Main window = new Main();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		List listClass = null;
		String pkg = "com.wang.Win1.all";
		listClass = Class
		*/
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		final Display display = Display.getDefault();
		shell = new Shell();
	    final Board board = new Board();
		gcMain = new GC(shell);
		shell.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent arg0) {
				board.refresh();
			}
		});
		shell.addMouseMoveListener(new MouseMoveListener() {
			public void mouseMove(MouseEvent arg0) {
				if(leftButtonDown) {
					gcMain.setLineStyle(SWT.LINE_DOT);
					
					//�ڸ�֮ǰ��ͼ��ʾ
					gcMain.setForeground(shell.getBackground());
					gcMain.drawRectangle(startX, startY, lastWidth,lastHeight);
					
					//����λ��
					lastWidth = arg0.x-startX;
					lastHeight = arg0.y-startY;
					
					//����µĿ�ͼ��ʾ
					gcMain.setForeground(display.getSystemColor(SWT.COLOR_BLACK));
					gcMain.drawRectangle(startX, startY,lastWidth,lastHeight);
				}
			}
		});
		shell.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				shell.setCursor(new Cursor(null,SWT.CURSOR_CROSS));
				if(e.button==1) {
					lastWidth = 0;
					lastHeight = 0;
					startX = e.x;
					startY = e.y;
					leftButtonDown = true;
				}
			}
			@Override
			public void mouseUp(MouseEvent e) {
				leftButtonDown = false;
				shell.setCursor(new Cursor(null,SWT.CURSOR_ARROW));
				IShape shape = null; 
				if(e.button==1) {
					int height = e.y - startY;
					int width = e.x - startX;
					//==============================================
					/**
					 * ����߿�
					 */
					if(shapeType == "Rect") {	
					}else {
						gcMain.setLineStyle(SWT.LINE_DOT);
						gcMain.setForeground(shell.getBackground());
						gcMain.drawRectangle(startX, startY, lastWidth,lastHeight);
					}
					
					/**
					 * �����ػ���ʽ
					 */
					gcMain.setLineStyle(SWT.LINE_SOLID);
					gcMain.setForeground(display.getSystemColor(SWT.COLOR_BLACK));
					
					/**
					 * ����ͼ�ε���ͼ�壬���ػ�����ͼ��
					 */
					try {
						Class<?> shapeClass = Class.forName("com.wang.Win1.all."+shapeType);
						Object oShape = shapeClass.getDeclaredConstructor().newInstance();		
						shape = (IShape)oShape;
						shape.setTop(startX);
						shape.setLeft(startY);
						shape.setWidth(width);
						shape.setHeight(height);
						shape.setGcMain(gcMain);
						if (shapeType == "FiveStar"|| shapeType == "Pentagon") {
							shape.runInner();
						}
						board.insertShape(shape);
						board.refresh();
						System.out.println(board.printLen());
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}catch (InstantiationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IllegalAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IllegalArgumentException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (InvocationTargetException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (NoSuchMethodException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SecurityException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					/**
					 * ʹ�÷�����ƺͶ�̬��󽵵��˳���ĸ��Ӷ�
					 */
					/*
					switch(shapeType) {
						case "Rect":{
							gcMain.setLineStyle(SWT.LINE_DOT);
							gcMain.setForeground(shell.getBackground());
							gcMain.drawRectangle(startX, startY, lastWidth,lastHeight);
							gcMain.setForeground(display.getSystemColor(SWT.COLOR_BLACK));
							gcMain.setLineStyle(SWT.LINE_SOLID);
							//Circle circle = new Circle(startX,startY,width,height,gcMain);
							board.insertShape(shape);
							board.refresh();
							leftButtonDown = false;
							break;
						}case "Circle":{
							gcMain.setLineStyle(SWT.LINE_SOLID);
							//Rect rect = new Rect(startX,startY,width,height,gcMain);
							board.insertShape(shape);
							board.refresh();
							leftButtonDown = false;
							break;
						}
						case "RRect":{//��һ��Բ�Ǿ���===============================
							board.insertShape(shape);
							board.refresh();
							leftButtonDown = false;
							break;
						}
						default:{
							gcMain.setLineStyle(SWT.LINE_DOT);
							gcMain.setForeground(shell.getBackground());
							gcMain.drawRectangle(startX, startY, lastWidth,lastHeight);
							gcMain.setForeground(display.getSystemColor(SWT.COLOR_BLACK));
							gcMain.setLineStyle(SWT.LINE_SOLID);
							Circle circle = new Circle(startX,startY,width,height,gcMain);
							board.insertShape(circle);
							board.refresh();
							leftButtonDown = false;
							break;
						}	
					}*/
				}
			}
		});
		shell.setSize(600, 600);
		shell.setText("SWT Application");
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shapeType = "Circle";
			}
		});
		btnNewButton.setBounds(0, 520, 50, 30);
		btnNewButton.setText("Circle");
		btnNewButton.setToolTipText("Բ��");
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shapeType = "Rect";
			}
		});
		btnNewButton_1.setBounds(50, 520, 50, 30);
		btnNewButton_1.setText("Rect");
		btnNewButton_1.setToolTipText("����");
		
		Button btnNewButton_2 = new Button(shell, SWT.NONE);
		btnNewButton_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shapeType = "RRect";
			}
		});
		btnNewButton_2.setBounds(100, 520, 50, 30);
		btnNewButton_2.setText("RRect");
		btnNewButton_2.setToolTipText("Բ�Ǿ���");

		
		Button btnNewButton_3 = new Button(shell, SWT.NONE);
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				/*
				//String fileName = "source.jpg";
				String saveName = "saved.jpg";
				ImageLoader loader = new ImageLoader();
				//ImageData[] imageData = loader.load(fileName);
				//if(imageData.length > 0){
				Image newImage = new Image(null, imageData[0]);
				loader.data[0] = newImage.getImageData();
				loader.save(saveName, SWT.IMAGE_BMP);
				//}*/
				try {
					Point p = shell.toDisplay(shell.getLocation());
				    Robot robot=new Robot();
				    //����ָ��������ץȡ��Ļ��ָ������1300�ǳ��ȣ�800�ǿ�ȡ�
				    Rectangle rect = new Rectangle(0,0,600,600);
				    BufferedImage bi=robot.createScreenCapture(rect);
				    //��ץȡ��������д��һ��jpg�ļ���
				    ImageIO.write(bi, "jpg", new File("E:\\դ��1.png"));
				    System.err.println("ͼƬ����ɹ���");
				    System.err.println(p.x + " "+p.y);
				    System.err.println(rect.x);
				    System.err.println(rect.y);
				    System.err.println(rect.width);
				    System.err.println(rect.height);
				    
				} catch (AWTException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_3.addKeyListener(new KeyAdapter() {
			/*
			@Override
			public void keyPressed(KeyEvent e) {

				String fileName = "source.jpg";
				String saveName = "saved.jpg";
				ImageLoader loader = new ImageLoader();
				ImageData[] imageData = loader.load(fileName);
				if(imageData.length > 0){
				Image newImage = new Image(null, imageData[0]);
				loader.data[0] = newImage.getImageData();
				loader.save(saveName, SWT.IMAGE_BMP);
				}
			}
			*/
			
		});
		btnNewButton_3.setBounds(530, 520, 50, 30);
		btnNewButton_3.setText("\u4FDD\u5B58");
		btnNewButton_3.setToolTipText("������ɱ�������Ϳѻ");
		
		Button btnNewButton_4 = new Button(shell, SWT.NONE);
		btnNewButton_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//������һ��ͼ�εĻ���
				gcMain.setForeground(shell.getBackground());
				board.refresh();
				
				//ʵ��ɾ�������ж������ػ�
				gcMain.setForeground(display.getSystemColor(SWT.COLOR_BLACK));
				board.del_last();
				board.refresh(); 
				 System.err.println("���سɹ���");
			}
		});
		btnNewButton_4.setBounds(160, 520, 50, 30);
		btnNewButton_4.setText("\u8FD4\u56DE");
		
		Button button = new Button(shell, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shapeType = "FiveStar";
			}
		});
		button.setBounds(221, 520, 71, 30);
		button.setText("\u4E94\u89D2\u661F");
		
		Button button_1 = new Button(shell, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shapeType = "Pentagon";
			}
		});
		button_1.setBounds(297, 520, 83, 30);
		button_1.setText("\u6B63\u4E94\u8FB9\u5F62");

	}
}
