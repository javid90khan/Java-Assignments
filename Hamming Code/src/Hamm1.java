/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author javidkhan
 */
import java.io.*;
import java.lang.Math;
import java.util.*;
 
class Hamm1{
static int n,i,m,k;
static int ham[]=new int[50];
static int data[]=new int[50];
 
static DataInputStream in= new DataInputStream(System.in);
 
public static void main(String args[])throws Exception{
 
 
acceptString();
 
hammCode();
 
System.out.println("hamming code:");
for(i=0;i<n+m;i++)
System.out.print(data[i]);
 
System.out.print("\nproduce error 1/0: ");
 int ch=Integer.parseInt(in.readLine());
 if(ch==1)
   {
     Random r=new Random();
     int no;
    no=r.nextInt(m);
     if(data[no]==0)      data[no]=1;
     else data[no]=0;
 
}
 
System.out.println("received code:");
for(i=0;i<n+m;i++){
 
System.out.print(data[i]);
}
 
hammCode();
 
 
String err="";
 
for(i=n-1;i>=0;i--){
 
err+=data[ham[i]];}
 
if(Integer.parseInt(err)!=0)
 
System.out.println("\nerror at position:"+(Integer.parseInt(err,2)));
else
System.out.println("\nno error");
 
}
 
 
public static void acceptString()throws Exception{
System.out.println("Enter data Stream:");
 
String datas=in.readLine();
m=datas.length();
n=findN(m);
int j=0;
for(i=0;i<n+m;i++){
if(!hamPos(i)){
data[i]=Integer.parseInt(new String(datas.charAt(j)+""));
j++;
}
}}
 
public static int findN(int m){
int n;
for(n=0;Math.pow(2,n)<(m+n);n++);
return n;
}
 
 
public static boolean hamPos(int p){
 
for(int i=0;i<n;i++)
ham[i]=(int)Math.pow(2,i)-1;
 
int f=0;
for(int i=0;i<n;i++)
if(p==ham[i])
f=1;
if(f==1)
return (true);
else
return (false);
}
 
 
public static void hammCode(){
 
int j=0;
for(int i=0;i<n;i++){
 
int correct=data[ham[i]];
j=ham[i];
 
while(j<m+n){
for(k=0;k<=ham[i];k++)
data[ham[i]]=data[ham[i]]^data[j+k];
 
j+=(ham[i]+1)*2;
}
data[ham[i]]=data[ham[i]]^correct;
}
}
}
 
 

