package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner inn=new Scanner(System.in);
        Student s1=new Student(inn.next(),inn.next());

        int nrnote=inn.nextInt();
        s1.note=new int[nrnote];
        for(int i=0;i<nrnote;i++)
        {
            s1.note[i]=inn.nextInt();
        }
        Grupa g1=new Grupa(inn.nextInt());

        Student s2=new Student(inn.next(),inn.next());
        nrnote=inn.nextInt();
        s2.note=new int[nrnote];
        for(int i=0;i<nrnote;i++)
        {
            s2.note[i]=inn.nextInt();
        }
        Grupa g2=new Grupa(inn.nextInt());

        Clasa c=new Clasa(1,2);
        c.grupe[0]=g2;
        c.studenti[0]=s1;
        c.studenti[1]=s2;

    }
}
