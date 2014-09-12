package net.minecraft.server;


public class aln extends alq {

   private final Class a;


   public aln(Class var1) {
      this.a = var1;
      this.a(akf.c);
   }

   public boolean a(amj var1, EntityHuman var2, World var3, Location var4, ej var5, float var6, float var7, float var8) {
      if(var5 == ej.a) {
         return false;
      } else if(var5 == ej.b) {
         return false;
      } else {
         Location var9 = var4.a(var5);
         if(!var2.a(var9, var5, var1)) {
            return false;
         } else {
            EntityHanging var10 = this.a(var3, var9, var5);
            if(var10 != null && var10.j()) {
               if(!var3.D) {
                  var3.d((Entity)var10);
               }

               --var1.b;
            }

            return true;
         }
      }
   }

   private EntityHanging a(World var1, Location var2, ej var3) {
      return (EntityHanging)(this.a == EntityPainting.class?new EntityPainting(var1, var2, var3):(this.a == EntityItemFrame.class?new EntityItemFrame(var1, var2, var3):null));
   }
}
