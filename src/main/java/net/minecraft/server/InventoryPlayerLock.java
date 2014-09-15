package net.minecraft.server;

public class InventoryPlayerLock {

   public static final InventoryPlayerLock a = new InventoryPlayerLock("");
   private final String b;


   public InventoryPlayerLock(String var1) {
      this.b = var1;
   }

   public boolean a() {
      return this.b == null || this.b.isEmpty();
   }

   public String b() {
      return this.b;
   }

   public void a(NBTTagCompound var1) {
      var1.setString("Lock", this.b);
   }

   public static InventoryPlayerLock b(NBTTagCompound var0) {
      if(var0.hasKeyOfType("Lock", 8)) {
         String var1 = var0.getString("Lock");
         return new InventoryPlayerLock(var1);
      } else {
         return a;
      }
   }

}
