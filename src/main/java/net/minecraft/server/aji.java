package net.minecraft.server;

public class aji implements vq {

   private amj[] a = new amj[1];


   public int n_() {
      return 1;
   }

   public amj a(int var1) {
      return this.a[0];
   }

   public String d_() {
      return "Result";
   }

   public boolean k_() {
      return false;
   }

   public IChatBaseComponent e_() {
      return (IChatBaseComponent)(this.k_()?new ChatComponentText(this.d_()):new hz(this.d_(), new Object[0]));
   }

   public amj a(int var1, int var2) {
      if(this.a[0] != null) {
         amj var3 = this.a[0];
         this.a[0] = null;
         return var3;
      } else {
         return null;
      }
   }

   public amj b(int var1) {
      if(this.a[0] != null) {
         amj var2 = this.a[0];
         this.a[0] = null;
         return var2;
      } else {
         return null;
      }
   }

   public void a(int var1, amj var2) {
      this.a[0] = var2;
   }

   public int p_() {
      return 64;
   }

   public void o_() {}

   public boolean a(ahd var1) {
      return true;
   }

   public void b(ahd var1) {}

   public void c(ahd var1) {}

   public boolean b(int var1, amj var2) {
      return true;
   }

   public int a_(int var1) {
      return 0;
   }

   public void b(int var1, int var2) {}

   public int g() {
      return 0;
   }

   public void l() {
      for(int var1 = 0; var1 < this.a.length; ++var1) {
         this.a[var1] = null;
      }

   }
}
