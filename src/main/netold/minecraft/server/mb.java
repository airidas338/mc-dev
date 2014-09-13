package net.minecraft.server;

public class mb implements id {

   private int a;


   public void a(hg var1) { // ls
	   ((ls)var1).a(this);
}

   public void a(hd var1) {
      this.a = var1.readByte();
   }

   public void b(hd var1) {
      var1.writeByte(this.a);
   }
}
