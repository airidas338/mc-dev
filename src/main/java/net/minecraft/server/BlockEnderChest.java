package net.minecraft.server;
import com.google.common.base.Predicate;

import java.util.Random;

public class BlockEnderChest extends atg {

   public static final beu a = beu.a("facing", (Predicate)en.a);


   protected BlockEnderChest() {
      super(Material.STONE);
      this.j(this.L.b().a(a, ej.c));
      this.a(CreativeModeTab.c);
      this.a(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
   }

   public boolean c() {
      return false;
   }

   public boolean d() {
      return false;
   }

   public int b() {
      return 2;
   }

   public Item a(IBlock var1, Random var2, int var3) {
      return Item.a(aty.Z);
   }

   public int a(Random var1) {
      return 8;
   }

   protected boolean G() {
      return true;
   }

   public IBlock a(World var1, Location var2, ej var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
      return this.P().a(a, var8.aO().d());
   }

   public void a(World var1, Location var2, IBlock var3, EntityLiving var4, amj var5) {
      var1.a(var2, var3.a(a, var4.aO().d()), 2);
   }

   public boolean a(World var1, Location var2, IBlock var3, EntityHuman var4, ej var5, float var6, float var7, float var8) {
      ajh var9 = var4.cn();
      bcm var10 = var1.s(var2);
      if(var9 != null && var10 instanceof bda) {
         if(var1.getData(var2.a()).c().t()) {
            return true;
         } else if(var1.D) {
            return true;
         } else {
            var9.a((bda)var10);
            var4.a((vq)var9);
            return true;
         }
      } else {
         return true;
      }
   }

   public bcm a(World var1, int var2) {
      return new bda();
   }

   public IBlock a(int var1) {
      ej var2 = ej.a(var1);
      if(var2.k() == el.b) {
         var2 = ej.c;
      }

      return this.P().a(a, var2);
   }

   public int c(IBlock var1) {
      return ((ej)var1.b(a)).a();
   }

   protected bed e() {
      return new bed(this, new bex[]{a});
   }

}