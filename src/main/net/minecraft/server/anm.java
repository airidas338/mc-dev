package net.minecraft.server;
import com.google.common.collect.Multimap;

public class anm extends alq {

   private float a;
   private final ami b;


   public anm(ami var1) {
      this.b = var1;
      this.h = 1;
      this.d(var1.a());
      this.a(akf.j);
      this.a = 4.0F + var1.c();
   }

   public float g() {
      return this.b.c();
   }

   public float a(amj var1, Block var2) {
      if(var2 == aty.G) {
         return 15.0F;
      } else {
         Material var3 = var2.r();
         return var3 != Material.k && var3 != Material.l && var3 != Material.v && var3 != Material.j && var3 != Material.C?1.0F:1.5F;
      }
   }

   public boolean a(amj var1, EntityLiving var2, EntityLiving var3) {
      var1.a(1, var3);
      return true;
   }

   public boolean a(amj var1, World var2, Block var3, Location var4, EntityLiving var5) {
      if((double)var3.g(var2, var4) != 0.0D) {
         var1.a(2, var5);
      }

      return true;
   }

   public ano e(amj var1) {
      return ano.d;
   }

   public int d(amj var1) {
      return 72000;
   }

   public amj a(amj var1, World var2, EntityHuman var3) {
      var3.a(var1, this.d(var1));
      return var1;
   }

   public boolean b(Block var1) {
      return var1 == aty.G;
   }

   public int b() {
      return this.b.e();
   }

   public String h() {
      return this.b.toString();
   }

   public boolean a(amj var1, amj var2) {
      return this.b.f() == var2.b()?true:super.a(var1, var2);
   }

   public Multimap i() {
      Multimap var1 = super.i();
      var1.put(GenericAttributes.e.a(), new ya(f, "Weapon modifier", (double)this.a, 0));
      return var1;
   }
}
