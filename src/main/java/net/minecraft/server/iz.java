package net.minecraft.server;

public class iz implements id {

   private IChatBaseComponent a;
   private byte b;


   public iz() {}

   public iz(IChatBaseComponent var1) {
      this(var1, (byte)1);
   }

   public iz(IChatBaseComponent var1, byte var2) {
      this.a = var1;
      this.b = var2;
   }

   public void a(hd var1) {
      this.a = var1.d();
      this.b = var1.readByte();
   }

   public void b(hd var1) {
      var1.a(this.a);
      var1.writeByte(this.b);
   }

   public void a(hg var1) {
      ((ik)var1).a(this);
   }

   public boolean b() {
      return this.b == 1 || this.b == 2;
   }
}
