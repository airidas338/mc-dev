package net.minecraft.server;
import java.util.Iterator;

public abstract class axm extends baa {

   public static final bev a = bev.a("axis", axo.class);


   public axm() {
      super(Material.d);
      this.a(akf.b);
      this.c(2.0F);
      this.a(f);
   }

   public void b(World var1, Location var2, IBlock var3) {
      byte var4 = 4;
      int var5 = var4 + 1;
      if(var1.a(var2.a(-var5, -var5, -var5), var2.a(var5, var5, var5))) {
         Iterator var6 = Location.a(var2.a(-var4, -var4, -var4), var2.a(var4, var4, var4)).iterator();

         while(var6.hasNext()) {
            Location var7 = (Location)var6.next();
            IBlock var8 = var1.p(var7);
            if(var8.c().r() == Material.j && !((Boolean)var8.b(axg.b)).booleanValue()) {
               var1.a(var7, var8.a(axg.b, Boolean.valueOf(true)), 4);
            }
         }

      }
   }

   public IBlock a(World var1, Location var2, ej var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
      return super.a(var1, var2, var3, var4, var5, var6, var7, var8).a(a, axo.a(var3.k()));
   }

}