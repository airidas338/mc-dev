package net.minecraft.server;

public class aon {

   private Object[][] a;


   public aon() {
      this.a = new Object[][]{{Blocks.R, new amj(Items.k, 9)}, {Blocks.S, new amj(Items.j, 9)}, {Blocks.ah, new amj(Items.i, 9)}, {Blocks.bT, new amj(Items.bO, 9)}, {Blocks.y, new amj(Items.aW, 9, akv.l.b())}, {Blocks.cn, new amj(Items.aC, 9)}, {Blocks.cA, new amj(Items.h, 9, 0)}, {Blocks.cx, new amj(Items.O, 9)}, {Blocks.cE, new amj(Items.aM, 9)}};
   }

   public void a(aop var1) {
      for(int var2 = 0; var2 < this.a.length; ++var2) {
         Block var3 = (Block)this.a[var2][0];
         amj var4 = (amj)this.a[var2][1];
         var1.a(new amj(var3), new Object[]{"###", "###", "###", Character.valueOf('#'), var4});
         var1.a(var4, new Object[]{"#", Character.valueOf('#'), var3});
      }

      var1.a(new amj(Items.k), new Object[]{"###", "###", "###", Character.valueOf('#'), Items.bx});
      var1.a(new amj(Items.bx, 9), new Object[]{"#", Character.valueOf('#'), Items.k});
   }
}
