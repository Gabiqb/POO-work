package schimbvalutar;

public class Main {
    public static void main(String[] args)
    {
        XchangeView xv=new XchangeView();
        XchangeController xc=new XchangeController(new XchangeModel(),xv);
        xv.setVisible(true);
    }
}
