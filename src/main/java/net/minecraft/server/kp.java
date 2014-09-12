package net.minecraft.server;

public class kp implements id {

   private int a;
   private EnumDifficulty b;
   private EnumGamemode c;
   private WorldType d;


   public kp() {}

   public kp(int var1, EnumDifficulty var2, WorldType var3, EnumGamemode var4) {
      this.a = var1;
      this.b = var2;
      this.c = var4;
      this.d = var3;
   }

   public void a(hg var1) {
      ((ik)var1).a(this);
   }

   public void a(hd var1) {
      this.a = var1.readInt();
      this.b = EnumDifficulty.a(var1.readUnsignedByte());
      this.c = EnumGamemode.a(var1.readUnsignedByte());
      this.d = WorldType.a(var1.c(16));
      if(this.d == null) {
         this.d = WorldType.NORMAL;
      }

   }

   public void b(hd var1) {
      var1.writeInt(this.a);
      var1.writeByte(this.b.a());
      var1.writeByte(this.c.a());
      var1.a(this.d.a());
   }
}
