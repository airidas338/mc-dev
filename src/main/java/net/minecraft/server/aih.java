package net.minecraft.server;

class aih extends ajk {

   // $FF: synthetic field
   final aig a;


   public aih(aig var1, vq var2, int var3, int var4, int var5) {
      super(var2, var3, var4, var5);
      this.a = var1;
   }

   public boolean a(amj var1) {
      return var1 == null?false:var1.b() == Items.bO || var1.b() == Items.i || var1.b() == Items.k || var1.b() == Items.j;
   }

   public int a() {
      return 1;
   }
}
