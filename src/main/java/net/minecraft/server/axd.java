package net.minecraft.server;

public class axd extends bcm {

   private amj a;


   public void a(NBTTagCompound var1) {
      super.a(var1);
      if(var1.b("RecordItem", 10)) {
         this.a(amj.a(var1.m("RecordItem")));
      } else if(var1.f("Record") > 0) {
         this.a(new amj(Item.b(var1.f("Record")), 1, 0));
      }

   }

   public void b(NBTTagCompound var1) {
      super.b(var1);
      if(this.a() != null) {
         var1.a("RecordItem", (NBTBase)this.a().b(new NBTTagCompound()));
      }

   }

   public amj a() {
      return this.a;
   }

   public void a(amj var1) {
      this.a = var1;
      this.o_();
   }
}
