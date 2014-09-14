package net.minecraft.server;


public class CommandKill extends CommandAbstract {

   public String c() {
      return "kill";
   }

   public int a() {
      return 2;
   }

   public String c(ICommandListener var1) {
      return "commands.kill.usage";
   }

   public void a(ICommandListener var1, String[] var2) throws CommandException {
      if(var2.length == 0) {
         EntityPlayer var4 = b(var1);
         var4.G();
         a(var1, this, "commands.kill.successful", new Object[]{var4.e_()});
      } else {
         Entity var3 = b(var1, var2[0]);
         var3.G();
         a(var1, this, "commands.kill.successful", new Object[]{var3.e_()});
      }
   }

   public boolean b(String[] var1, int var2) {
      return var2 == 0;
   }
}
