package net.minecraft.server;

public class jd implements id {

   private int a;


   public jd() {}

   public jd(int var1) {
      this.a = var1;
   }

   public void a(hg var1) { // ik
      var1.a(this);
   }

   public void a(hd var1) {
      this.a = var1.readUnsignedByte();
   }

   public void b(hd var1) {
      var1.writeByte(this.a);
   }
}
