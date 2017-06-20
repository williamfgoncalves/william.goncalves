
package br.com.crescer.aula1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class HelloWorldApp {
  
    public static void main(String[] args) { 
	try (final InputStreamReader inputStreamReader = new InputStreamReader(System.in)) {
        try (final BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            System.out.print("Digite um numero: ");
			int a = Integer.parseInt(bufferedReader.readLine());
			
			if(a%2 == 0){
				System.out.println(a + " eh um numero par");
			}
			else{
				System.out.println(a + " eh um numero impar");
			}
			
        } catch (Exception e) {
                //...
        }
    } catch (Exception e) {
            //...
    }
  }
    
}