package net.minecraft.server;
import com.google.common.collect.Multimap;

import java.util.Set;

public class aks extends Item {

   private Set c;
   protected float a = 4.0F;
   private float d;
   protected EnumToolMaterial b;


   protected aks(float var1, EnumToolMaterial var2, Set var3) {
      this.b = var2;
      this.c = var3;
      this.maxStackSize = 1;
      this.d(var2.a());
      this.a = var2.b();
      this.d = var1 + var2.c();
      this.a(CreativeModeTab.i);
   }

   public float a(ItemStack var1, Block var2) {
      return this.c.contains(var2)?this.a:1.0F;
   }

   public boolean a(ItemStack var1, EntityLiving var2, EntityLiving var3) {
      var1.damage(2, var3);
      return true;
   }

   public boolean a(ItemStack var1, World var2, Block var3, Location var4, EntityLiving var5) {
      if((double)var3.g(var2, var4) != 0.0D) {
         var1.damage(1, var5);
      }

      return true;
   }

   public EnumToolMaterial g() {
      return this.b;
   }

   public int b() {
      return this.b.e();
   }

   public String h() {
      return this.b.toString();
   }

   public boolean a(ItemStack var1, ItemStack var2) {
      return this.b.f() == var2.getItem()?true:super.a(var1, var2);
   }

   public Multimap i() {
      Multimap var1 = super.i();
      var1.put(GenericAttributes.e.getName(), new AttributeModifier(f, "Tool modifier", (double)this.d, 0));
      return var1;
   }
}
