package net.minecraft.server;

public class aon {

   private Object[][] a;


   public aon() {
      this.a = new Object[][]{{Blocks.R, new ItemStack(Items.k, 9)}, {Blocks.S, new ItemStack(Items.j, 9)}, {Blocks.ah, new ItemStack(Items.i, 9)}, {Blocks.bT, new ItemStack(Items.bO, 9)}, {Blocks.y, new ItemStack(Items.aW, 9, akv.l.b())}, {Blocks.cn, new ItemStack(Items.aC, 9)}, {Blocks.cA, new ItemStack(Items.h, 9, 0)}, {Blocks.cx, new ItemStack(Items.O, 9)}, {Blocks.cE, new ItemStack(Items.aM, 9)}};
   }

   public void a(aop var1) {
      for(int var2 = 0; var2 < this.a.length; ++var2) {
         Block var3 = (Block)this.a[var2][0];
         ItemStack var4 = (ItemStack)this.a[var2][1];
         var1.a(new ItemStack(var3), new Object[]{"###", "###", "###", Character.valueOf('#'), var4});
         var1.a(var4, new Object[]{"#", Character.valueOf('#'), var3});
      }

      var1.a(new ItemStack(Items.k), new Object[]{"###", "###", "###", Character.valueOf('#'), Items.bx});
      var1.a(new ItemStack(Items.bx, 9), new Object[]{"#", Character.valueOf('#'), Items.k});
   }
}
