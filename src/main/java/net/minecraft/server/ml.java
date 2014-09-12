package net.minecraft.server;

public class ml implements id {

   private Location a;
   private ej b;
   private mm c;


   public void a(hd var1) {
      this.c = (mm)var1.a(mm.class);
      this.a = var1.c();
      this.b = ej.a(var1.readUnsignedByte());
   }

   public void b(hd var1) {
      var1.a((Enum)this.c);
      var1.a(this.a);
      var1.writeByte(this.b.a());
   }

   public void a(hg var1) {
      ((ls)var1).a(this);
   }

   public Location a() {
      return this.a;
   }

   public ej b() {
      return this.b;
   }

   public mm c() {
      return this.c;
   }
}
