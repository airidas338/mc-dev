package net.minecraft.server;

public class bdb extends bcm {

   private Item a;
   private int f;


   public bdb() {}

   public bdb(Item var1, int var2) {
      this.a = var1;
      this.f = var2;
   }

   public void b(NBTTagCompound var1) {
      super.b(var1);
      RegistryMaterials var2 = (RegistryMaterials)Item.e.c(this.a);
      var1.a("Item", var2 == null?"":var2.toString());
      var1.a("Data", this.f);
   }

   public void a(NBTTagCompound var1) {
      super.a(var1);
      if(var1.b("Item", 8)) {
         this.a = Item.d(var1.j("Item"));
      } else {
         this.a = Item.b(var1.f("Item"));
      }

      this.f = var1.f("Data");
   }

   public Packet x_() {
      NBTTagCompound var1 = new NBTTagCompound();
      this.b(var1);
      var1.o("Item");
      var1.a("Item", Item.b(this.a));
      return new iu(this.c, 5, var1);
   }

   public void a(Item var1, int var2) {
      this.a = var1;
      this.f = var2;
   }

   public Item b() {
      return this.a;
   }

   public int c() {
      return this.f;
   }
}
