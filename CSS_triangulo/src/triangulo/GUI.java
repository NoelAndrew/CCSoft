package triangulo;

import javax.swing.JOptionPane;


import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import com.ibm.icu.impl.Trie;

import javatriangle.JavaTriangle;

public class GUI {
    private PaintTriangle paintTriangle1;
    private PaintTriangle paintTriangle2;

	protected Shell shell;
	private Text lado1;
	private Text lado2;
	private Text lado3;
	Text resultado;

	/**
	 * 
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			GUI window = new GUI();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
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
        paintTriangle1 = new PaintTriangle();
		shell = new Shell();
		shell.setSize(375, 526);
		shell.setText("Triangulos");
		
		Label lblLado = new Label(shell, SWT.NONE);
		lblLado.setBounds(26, 52, 55, 15);
		lblLado.setText("Lado 1:");
		
		Label lblLado2 = new Label(shell, SWT.NONE);
		lblLado2.setBounds(26, 85, 55, 15);
		lblLado2.setText("Lado 2:");
		
		Label lblLado3 = new Label(shell, SWT.NONE);
		lblLado3.setBounds(26, 120, 55, 15);
		lblLado3.setText("Lado 3:");
		
		lado1 = new Text(shell, SWT.BORDER);
		lado1.setBounds(81, 46, 76, 21);
		
		lado2 = new Text(shell, SWT.BORDER);
		lado2.setBounds(81, 79, 76, 21);
		
		lado3 = new Text(shell, SWT.BORDER);
		lado3.setBounds(81, 114, 76, 21);
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBounds(71, 286, 151, 137);
		
		Button btnMostrar = new Button(shell, SWT.NONE);
        paintTriangle2 = new PaintTriangle();

        javax.swing.GroupLayout paintTriangle1Layout = new javax.swing.GroupLayout(paintTriangle1);
        paintTriangle1.setLayout(paintTriangle1Layout);
        paintTriangle1Layout.setHorizontalGroup(
            paintTriangle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );
        paintTriangle1Layout.setVerticalGroup(
            paintTriangle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 483, Short.MAX_VALUE)
        );



		btnMostrar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String A = lado1.getText();
				String B = lado2.getText();
				String C = lado3.getText();
				if(A.isEmpty() || B.isEmpty() || C.isEmpty())
				{
					if(A.isEmpty())
					{
						System.out.println("lado 1 esta vacio");
						JOptionPane.showMessageDialog(null, "Casilla 1 esta vacia");
					}
					if(B.isEmpty())
					{
						System.out.println("lado 2 esta vacio");
						JOptionPane.showMessageDialog(null, "Casilla 2 esta vacia");
					}
					if(C.isEmpty())
					{
						System.out.println("lado 3 esta vacio");
						JOptionPane.showMessageDialog(null, "Casilla 3 esta vacia");
					}
				}
				else
				{
					String nom = JavaTriangle.Condicion(lado1.getText(),lado2.getText(),lado3.getText());
					if(!nom.isEmpty())
					{
						resultado.setText(nom);
						
					}
			        
			        		
				}
		        paintTriangle2.drawTriangle();

			}
		});
		btnMostrar.setBounds(26, 167, 75, 25);
		btnMostrar.setText("Crear");
		
		resultado = new Text(shell, SWT.BORDER);
		resultado.setBounds(26, 211, 304, 21);
		resultado.setEditable(false);
		resultado.setEnabled(false);
		
		
		
		Button btnLimpiar = new Button(shell, SWT.NONE);
		btnLimpiar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				resultado.setText("");
				lado1.setText("");
				lado2.setText("");
				lado3.setText("");
			}
		});
		btnLimpiar.setBounds(147, 452, 75, 25);
		btnLimpiar.setText("Limpiar");
		
		Label equi = new Label(shell, SWT.NONE);
		equi.setImage(SWTResourceManager.getImage("C:\\Users\\Noel\\Documents\\UNI\\CCS\\Trian\\src\\Images\\equi.jpg"));
		equi.setBounds(63, 238, 236, 208);
		equi.setVisible(false);

	}
	

}
