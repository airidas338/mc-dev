package net.minecraft.server;

public class ix implements id {

   private EnumDifficulty a;
   private boolean b;


   public ix() {}

   public ix(EnumDifficulty var1, boolean var2) {
      this.a = var1;
      this.b = var2;
   }

   public void a(PacketListener var1) {
      ((ik)var1).a(this);
   }

   public void a(hd var1) {
      this.a = EnumDifficulty.a(var1.readUnsignedByte());
   }

   public void b(hd var1) {
      var1.writeByte(this.a.a());
   }
}
