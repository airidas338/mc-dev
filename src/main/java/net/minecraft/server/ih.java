package net.minecraft.server;
import java.io.IOException;


final class ih implements Runnable {

   // $FF: synthetic field
   final id a;
   // $FF: synthetic field
   final hg b;


   ih(id var1, hg var2) {
      this.a = var1;
      this.b = var2;
   }

   public void run() {
      try {
		this.a.a(this.b);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
}