package net.minecraft.server;
import java.io.IOException;
import java.util.List;

public class io implements id {

   private int a;
   private int b;
   private int c;
   private int d;
   private int e;
   private int f;
   private int g;
   private int h;
   private byte i;
   private byte j;
   private byte k;
   private DataWatcher l;
   private List m;


   public io() {}

   public io(EntityLiving var1) {
      this.a = var1.F();
      this.b = (byte)EntityTypes.a(var1);
      this.c = MathHelper.c(var1.s * 32.0D);
      this.d = MathHelper.c(var1.t * 32.0D);
      this.e = MathHelper.c(var1.u * 32.0D);
      this.i = (byte)((int)(var1.y * 256.0F / 360.0F));
      this.j = (byte)((int)(var1.z * 256.0F / 360.0F));
      this.k = (byte)((int)(var1.aI * 256.0F / 360.0F));
      double var2 = 3.9D;
      double var4 = var1.v;
      double var6 = var1.w;
      double var8 = var1.x;
      if(var4 < -var2) {
         var4 = -var2;
      }

      if(var6 < -var2) {
         var6 = -var2;
      }

      if(var8 < -var2) {
         var8 = -var2;
      }

      if(var4 > var2) {
         var4 = var2;
      }

      if(var6 > var2) {
         var6 = var2;
      }

      if(var8 > var2) {
         var8 = var2;
      }

      this.f = (int)(var4 * 8000.0D);
      this.g = (int)(var6 * 8000.0D);
      this.h = (int)(var8 * 8000.0D);
      this.l = var1.H();
   }

   public void a(hd var1) throws IOException {
      this.a = var1.e();
      this.b = var1.readByte() & 255;
      this.c = var1.readInt();
      this.d = var1.readInt();
      this.e = var1.readInt();
      this.i = var1.readByte();
      this.j = var1.readByte();
      this.k = var1.readByte();
      this.f = var1.readShort();
      this.g = var1.readShort();
      this.h = var1.readShort();
      this.m = DataWatcher.b(var1);
   }

   public void b(hd var1) throws IOException {
      var1.b(this.a);
      var1.writeByte(this.b & 255);
      var1.writeInt(this.c);
      var1.writeInt(this.d);
      var1.writeInt(this.e);
      var1.writeByte(this.i);
      var1.writeByte(this.j);
      var1.writeByte(this.k);
      var1.writeShort(this.f);
      var1.writeShort(this.g);
      var1.writeShort(this.h);
      this.l.a(var1);
   }

   public void a(PacketListener var1) {
      ((ik)var1).a(this);
   }
}
