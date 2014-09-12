package net.minecraft.server;
import java.util.List;

public class cm extends CommandAbstract {

   public String c() {
      return "setblock";
   }

   public int a() {
      return 2;
   }

   public String c(ae var1) {
      return "commands.setblock.usage";
   }

   public void a(ae var1, String[] var2) throws di {
      if(var2.length < 4) {
         throw new dp("commands.setblock.usage", new Object[0]);
      } else {
         var1.a(ag.b, 0);
         Location var3 = a(var1, var2, 0, false);
         Block var4 = CommandAbstract.g(var1, var2[3]);
         int var5 = 0;
         if(var2.length >= 5) {
            var5 = a(var2[4], 0, 15);
         }

         World var6 = var1.e();
         if(!var6.e(var3)) {
            throw new di("commands.setblock.outOfWorld", new Object[0]);
         } else {
            fn var7 = new fn();
            boolean var8 = false;
            if(var2.length >= 7 && var4.x()) {
               String var9 = a(var1, var2, 6).c();

               try {
                  var7 = gg.a(var9);
                  var8 = true;
               } catch (gf var12) {
                  throw new di("commands.setblock.tagError", new Object[]{var12.getMessage()});
               }
            }

            if(var2.length >= 6) {
               if(var2[5].equals("destroy")) {
                  var6.b(var3, true);
                  if(var4 == aty.a) {
                     a(var1, this, "commands.setblock.success", new Object[0]);
                     return;
                  }
               } else if(var2[5].equals("keep") && !var6.d(var3)) {
                  throw new di("commands.setblock.noChange", new Object[0]);
               }
            }

            bcm var13 = var6.s(var3);
            if(var13 != null) {
               if(var13 instanceof vq) {
                  ((vq)var13).l();
               }

               var6.a(var3, aty.a.P(), var4 == aty.a?2:4);
            }

            IBlock var10 = var4.a(var5);
            if(!var6.a(var3, var10, 2)) {
               throw new di("commands.setblock.noChange", new Object[0]);
            } else {
               if(var8) {
                  bcm var11 = var6.s(var3);
                  if(var11 != null) {
                     var7.a("x", var3.n());
                     var7.a("y", var3.o());
                     var7.a("z", var3.p());
                     var11.a(var7);
                  }
               }

               var6.b(var3, var10.c());
               var1.a(ag.b, 1);
               a(var1, this, "commands.setblock.success", new Object[0]);
            }
         }
      }
   }

   public List a(ae var1, String[] var2, Location var3) {
      return var2.length > 0 && var2.length <= 3?a(var2, 0, var3):(var2.length == 4?a(var2, Block.c.c()):(var2.length == 6?a(var2, new String[]{"replace", "destroy", "keep"}):null));
   }
}
