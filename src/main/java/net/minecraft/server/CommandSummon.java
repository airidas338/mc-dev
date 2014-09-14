package net.minecraft.server;
import java.util.List;

public class CommandSummon extends CommandAbstract {

   public String c() {
      return "summon";
   }

   public int a() {
      return 2;
   }

   public String c(ICommandSender var1) {
      return "commands.summon.usage";
   }

   public void a(ICommandSender var1, String[] var2) throws CommandException {
      if(var2.length < 1) {
         throw new ExceptionUsage("commands.summon.usage", new Object[0]);
      } else {
         String var3 = var2[0];
         Location var4 = var1.c();
         Vec3D var5 = var1.d();
         double var6 = var5.a;
         double var8 = var5.b;
         double var10 = var5.c;
         if(var2.length >= 4) {
            var6 = b(var6, var2[1], true);
            var8 = b(var8, var2[2], false);
            var10 = b(var10, var2[3], true);
            var4 = new Location(var6, var8, var10);
         }

         World var12 = var1.e();
         if(!var12.e(var4)) {
            throw new CommandException("commands.summon.outOfWorld", new Object[0]);
         } else if("LightningBolt".equals(var3)) {
            var12.c((Entity)(new EntityLightning(var12, var6, var8, var10)));
            a(var1, this, "commands.summon.success", new Object[0]);
         } else {
            NBTTagCompound var13 = new NBTTagCompound();
            boolean var14 = false;
            if(var2.length >= 5) {
               IChatBaseComponent var15 = a(var1, var2, 4);

               try {
                  var13 = gg.a(var15.c());
                  var14 = true;
               } catch (gf var20) {
                  throw new CommandException("commands.summon.tagError", new Object[]{var20.getMessage()});
               }
            }

            var13.setString("id", var3);

            Entity var21;
            try {
               var21 = EntityTypes.a(var13, var12);
            } catch (RuntimeException var19) {
               throw new CommandException("commands.summon.failed", new Object[0]);
            }

            if(var21 == null) {
               throw new CommandException("commands.summon.failed", new Object[0]);
            } else {
               var21.setPositionRotation(var6, var8, var10, var21.y, var21.z);
               if(!var14 && var21 instanceof EntityInsentient) {
                  ((EntityInsentient)var21).a(var12.E(new Location(var21)), (xq)null);
               }

               var12.d(var21);
               Entity var16 = var21;

               for(NBTTagCompound var17 = var13; var16 != null && var17.hasKeyOfType("Riding", 10); var17 = var17.getCompound("Riding")) {
                  Entity var18 = EntityTypes.a(var17.getCompound("Riding"), var12);
                  if(var18 != null) {
                     var18.setPositionRotation(var6, var8, var10, var18.y, var18.z);
                     var12.d(var18);
                     var16.a(var18);
                  }

                  var16 = var18;
               }

               a(var1, this, "commands.summon.success", new Object[0]);
            }
         }
      }
   }

   public List a(ICommandSender var1, String[] var2, Location var3) {
      return var2.length == 1?a(var2, EntityTypes.b()):(var2.length > 1 && var2.length <= 4?a(var2, 1, var3):null);
   }
}
