package net.minecraft.server;

public class bu extends z {

   public String c() {
      return "kill";
   }

   public int a() {
      return 2;
   }

   public String c(ae var1) {
      return "commands.kill.usage";
   }

   public void a(ae var1, String[] var2) throws dm, dj {
      if(var2.length == 0) {
         qw var4 = b(var1);
         var4.G();
         a(var1, this, "commands.kill.successful", new Object[]{var4.e_()});
      } else {
         wv var3 = b(var1, var2[0]);
         var3.G();
         a(var1, this, "commands.kill.successful", new Object[]{var3.e_()});
      }
   }

   public boolean b(String[] var1, int var2) {
      return var2 == 0;
   }
}
