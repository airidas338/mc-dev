package net.minecraft.server;

public class aob {

   private String[][] a = new String[][]{{"XXX", "X X"}, {"X X", "XXX", "XXX"}, {"XXX", "X X", "X X"}, {"X X", "X X"}};
   private Item[][] b;


   public aob() {
      this.b = new Item[][]{{Items.aF, Items.j, Items.i, Items.k}, {Items.Q, Items.Y, Items.ac, Items.ag}, {Items.R, Items.Z, Items.ad, Items.ah}, {Items.S, Items.aa, Items.ae, Items.ai}, {Items.T, Items.ab, Items.af, Items.aj}};
   }

   public void a(aop var1) {
      for(int var2 = 0; var2 < this.b[0].length; ++var2) {
         Item var3 = this.b[0][var2];

         for(int var4 = 0; var4 < this.b.length - 1; ++var4) {
            Item var5 = this.b[var4 + 1][var2];
            var1.a(new amj(var5), new Object[]{this.a[var4], Character.valueOf('X'), var3});
         }
      }

   }
}
