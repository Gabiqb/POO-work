public class Scoala  {
    int m;
    int n;
    Camera[][] camere;
    public Scoala(int m,int n)
    {
        this.camere=new Camera[m][n];
        this.m=m;
        this.n=n;
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++) {
                this.camere[i][j] = new Camera(0, 0);

            }
    }


}
