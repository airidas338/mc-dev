package net.minecraft.server;

class air extends wa {

   // $FF: synthetic field
   final aiq a;


   air(aiq var1, String var2, boolean var3, int var4) {
      super(var2, var3, var4);
      this.a = var1;
   }

   public int p_() {
      return 64;
   }

   public void o_() {
      super.o_();
      this.a.a((vq)this);
   }
}
