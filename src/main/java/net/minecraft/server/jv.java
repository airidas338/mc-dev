package net.minecraft.server;
import org.apache.commons.lang3.Validate;

public class jv implements id {

   private String a;
   private int b;
   private int c = Integer.MAX_VALUE;
   private int d;
   private float e;
   private int f;


   public jv() {}

   public jv(String var1, double var2, double var4, double var6, float var8, float var9) {
      Validate.notNull(var1, "name", new Object[0]);
      this.a = var1;
      this.b = (int)(var2 * 8.0D);
      this.c = (int)(var4 * 8.0D);
      this.d = (int)(var6 * 8.0D);
      this.e = var8;
      this.f = (int)(var9 * 63.0F);
      var9 = MathHelper.a(var9, 0.0F, 255.0F);
   }

   public void a(hd var1) {
      this.a = var1.c(256);
      this.b = var1.readInt();
      this.c = var1.readInt();
      this.d = var1.readInt();
      this.e = var1.readFloat();
      this.f = var1.readUnsignedByte();
   }

   public void b(hd var1) {
      var1.a(this.a);
      var1.writeInt(this.b);
      var1.writeInt(this.c);
      var1.writeInt(this.d);
      var1.writeFloat(this.e);
      var1.writeByte(this.f);
   }

   public void a(hg var1) {
      ((ik)var1).a(this);
   }
}
