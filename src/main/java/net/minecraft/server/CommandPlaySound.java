package net.minecraft.server;
import java.util.List;

public class CommandPlaySound extends CommandAbstract {

   public String getCommand() {
      return "playsound";
   }

   public int a() {
      return 2;
   }

   public String c(ICommandListener var1) {
      return "commands.playsound.usage";
   }

   public void execute(ICommandListener var1, String[] var2) throws CommandException {
      if(var2.length < 2) {
         throw new ExceptionUsage(this.c(var1), new Object[0]);
      } else {
         byte var3 = 0;
         int var32 = var3 + 1;
         String var4 = var2[var3];
         EntityPlayer var5 = a(var1, var2[var32++]);
         Vec3D var6 = var1.d();
         double var7 = var6.a;
         if(var2.length > var32) {
            var7 = b(var7, var2[var32++], true);
         }

         double var9 = var6.b;
         if(var2.length > var32) {
            var9 = b(var9, var2[var32++], 0, 0, false);
         }

         double var11 = var6.c;
         if(var2.length > var32) {
            var11 = b(var11, var2[var32++], true);
         }

         double var13 = 1.0D;
         if(var2.length > var32) {
            var13 = a(var2[var32++], 0.0D, 3.4028234663852886E38D);
         }

         double var15 = 1.0D;
         if(var2.length > var32) {
            var15 = a(var2[var32++], 0.0D, 2.0D);
         }

         double var17 = 0.0D;
         if(var2.length > var32) {
            var17 = a(var2[var32], 0.0D, 1.0D);
         }

         double var19 = var13 > 1.0D?var13 * 16.0D:16.0D;
         double var21 = var5.f(var7, var9, var11);
         if(var21 > var19) {
            if(var17 <= 0.0D) {
               throw new CommandException("commands.playsound.playerTooFar", new Object[]{var5.getName()});
            }

            double var23 = var7 - var5.s;
            double var25 = var9 - var5.t;
            double var27 = var11 - var5.u;
            double var29 = Math.sqrt(var23 * var23 + var25 * var25 + var27 * var27);
            if(var29 > 0.0D) {
               var7 = var5.s + var23 / var29 * 2.0D;
               var9 = var5.t + var25 / var29 * 2.0D;
               var11 = var5.u + var27 / var29 * 2.0D;
            }

            var13 = var17;
         }

         var5.a.sendPacket((Packet)(new PacketPlayOutNamedSoundEffect(var4, var7, var9, var11, (float)var13, (float)var15)));
         a(var1, this, "commands.playsound.success", new Object[]{var4, var5.getName()});
      }
   }

   public List tabComplete(ICommandListener var1, String[] var2, Location var3) {
      return var2.length == 2?a(var2, MinecraftServer.M().I()):(var2.length > 2 && var2.length <= 5?a(var2, 2, var3):null);
   }

   public boolean isListStart(String[] var1, int var2) {
      return var2 == 1;
   }
}
