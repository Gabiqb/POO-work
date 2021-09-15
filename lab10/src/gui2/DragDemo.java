package gui2;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
///////////////////////////////////////////////////// clasa DragBallPanel
    /** La apelul ascultatorului mousePressed se testeaza pozitia
     pentru a vedea daca este in zona mingii. Daca este,
     (1) _canDrag este setat la true cu semnificatia "atentie la
     evenimentele MouseDragged".
     (2) se înregistreaza unde în minge (relative la coordonatele din
     stânga sus) a fost dat clic, fiindca arata cel mai bine daca o târâm
     de acolo.
     */
    public class DragDemo extends JPanel implements MouseListener, MouseMotionListener, ActionListener {
        Timer t;
        boolean sus,stanga=false;
        boolean dreapta=true;
        boolean jos=true;
        private static final int BALL_DIAMETER = 40; // Diametrul mingii
        //--- variabile instanta
        /** Coordonatele mingii. Modificate de ascultatori. Folosite de
         paintComponent. */
        private int _ballX = 50; // x coord – setata din târâre
        private int _ballY = 100; // y coord - setata din târâre
        int x1,y1,timp=0;
        /** Pozitia în minge a unei apasari pe mouse pentru a afce târârea sa
         arate mai bine */
        private int _dragFromX = 0; // apasat atât in interiorul
        private int _dragFromY = 0; // dreptunghiului mingii.

        /** true inseamna ca mouse a fost apasat in minge si înca in panou.*/
        private boolean _canDrag = false;

        //=============================================================

        /** Constructorul seteaza marimea, culorile si adauga ascultatori de
         mouse.*/
        public DragDemo() {
            setPreferredSize(new Dimension(300, 300));
            setBackground(Color.blue);
            setForeground(Color.yellow);
            //--- Add the mouse listeners.
            this.addMouseListener(this);
            this.addMouseMotionListener(this);
            t=new Timer(10, this);
            t.start();
        }//endconstructor

        //============================================= metoda paintComponent
        /** Mingea este desenata la ultimele coordinate înregistrate de
         ascultator */
        public void paintComponent(Graphics g) {
            super.paintComponent(g); // Required for background.

            g.fillOval(_ballX, _ballY, BALL_DIAMETER, BALL_DIAMETER);
            g.drawString("Coordonate:  " + String.format("x:%d  y:%d",_ballX,_ballY),0,10);


        }//end paintComponent
        //============================================== method mousePressed
        /** Seteaza _canDrag daca clic este în minge (sau în dreptunghiul care
         o margineste, ceea ce este destul de bun pentru acest program).
         Pastrati deplasamentul (dragFromX si Y) in minge ca sa-l folositi
         ca punct relativ de afisare în timpul tâtârii.
         */
        public void mousePressed(MouseEvent e) {
            int x = e.getX(); // Save the x coord of the click
            int y = e.getY(); // Save the y coord of the click

            if (x >= _ballX && x <= (_ballX + BALL_DIAMETER)
                    && y >= _ballY && y <= (_ballY + BALL_DIAMETER)) {
                _canDrag = true;
                _dragFromX = x - _ballX; // how far from left
                _dragFromY = y - _ballY; // how far from top
            } else {
                _canDrag = false;
            }
        }//end mousePressed

        //============================================ metoda mouseDragged
        /** Seteaza pozitia x,y a mouse si redeseneaza. */
        public void mouseDragged(MouseEvent e) {
            if (_canDrag) { // True doar la apasare in interiorul mingii.
                //--- Pozitia mingii din mouse si deplasament click original
                _ballX = e.getX() - _dragFromX;
                _ballY = e.getY() - _dragFromY;

                //--- Nu muta mingea in afara marginilor ecranului
                _ballX = Math.max(_ballX, 0);
                _ballX = Math.min(_ballX, getWidth() - BALL_DIAMETER);

                //--- Nu muta mingea pest marginile de sus sau jos
                _ballY = Math.max(_ballY, 0);
                _ballY = Math.min(_ballY, getHeight() - BALL_DIAMETER);

                this.repaint(); // Redeseneaza – s-a schimbat pozitia
            }
        }//end mouseDragged
        //================================================ metoda mouseExited
        /** Dezactiveaza târârea daca mouse iese din panou. */
        public void mouseExited(MouseEvent e) {
            _canDrag = false;
        }//end mouseExited
        //===================================== Ignora alte evenimente mouse.
        public void mouseMoved (MouseEvent e) {}
        public void mouseEntered (MouseEvent e) {}
        public void mouseClicked (MouseEvent e)
        {
            int x = e.getX(); // Save the x coord of the click
            int y = e.getY(); // Save the y coord of the click
            System.out.println("Clicked at "+ x + " "+ y);
            if (x >= _ballX && x <= (_ballX + BALL_DIAMETER) && y >= _ballY && y <= (_ballY + BALL_DIAMETER)) {

                _canDrag = true;
                _ballX=x1;
                _ballY =y1; // how far from top
                this.repaint();
            } else {
                _canDrag = false;
            }


        }
        public void mouseReleased(MouseEvent e) {}

        public void movingBall()
        {
           if(dreapta==true && _ballX<getWidth())
           {
               _ballX+=15;

           }
           if(stanga==true && _ballX>0)
           {
               _ballX-=15;

           }
           if(sus==true && _ballY>0)
           {
               _ballY-=5;
           }
           if(jos==true && _ballY<getHeight())
           {
               _ballY+=5;
           }
           if(_ballX+BALL_DIAMETER>getWidth())
           {
               dreapta=false;
               stanga=true;

           }
           if(_ballY+BALL_DIAMETER>getHeight())
           {
               sus=true;
               jos=false;

           }
           if(_ballX-1<0)
           {
               dreapta=true;
               stanga=false;

           }
            if(_ballY-BALL_DIAMETER<0)
            {
                jos=true;
                sus=false;

            }

          this.repaint();
           }


        @Override
        public void actionPerformed(ActionEvent e) {
            x1=(int)(Math.random()*getWidth());
            y1=(int)(Math.random()*getHeight());

            System.out.println("x: " + x1);
            timp+=t.getDelay();
            System.out.println("y: " + y1 );
            System.out.print("timp : "+ timp + "\n");
            movingBall();
        }
        public static void main(String[] args) {
            JFrame window = new JFrame();
            window.setTitle("Drag Demo");
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setContentPane(new DragDemo());
            window.pack();

            window.setVisible(true);
        }//end main


    }//endclass DragBallPanel

