package net.minecraft.server;
import java.io.IOException;


public class PacketPlayInFlying implements Packet {

   protected double a;
   protected double b;
   protected double c;
   protected float d;
   protected float e;
   protected boolean f;
   protected boolean g;
   protected boolean h;


   public void a(PacketListener var1) throws IOException {
      ((PacketPlayInListener)var1).a(this);
   }

   public void a(PacketDataSerializer var1) {
      this.f = var1.readUnsignedByte() != 0;
   }

   public void b(PacketDataSerializer var1) {
      var1.writeByte(this.f?1:0);
   }

   public double a() {
      return this.a;
   }

   public double b() {
      return this.b;
   }

   public double c() {
      return this.c;
   }

   public float d() {
      return this.d;
   }

   public float e() {
      return this.e;
   }

   public boolean f() {
      return this.f;
   }

   public boolean g() {
      return this.g;
   }

   public boolean h() {
      return this.h;
   }

   public void a(boolean var1) {
      this.g = var1;
   }
}
