package net.minecraft.server;

public enum EnchantmentSlotType {

   ALL("ALL", 0),
   ARMOR("ARMOR", 1),
   ARMOR_FEET("ARMOR_FEET", 2),
   ARMOR_LEGS("ARMOR_LEGS", 3),
   ARMOR_TORSO("ARMOR_TORSO", 4),
   ARMOR_HEAD("ARMOR_HEAD", 5),
   WEAPON("WEAPON", 6),
   DIGGER("DIGGER", 7),
   FISHING_ROD("FISHING_ROD", 8),
   BREAKABLE("BREAKABLE", 9),
   BOW("BOW", 10);
   // $FF: synthetic field
   private static final EnchantmentSlotType[] l = new EnchantmentSlotType[]{ALL, ARMOR, ARMOR_FEET, ARMOR_LEGS, ARMOR_TORSO, ARMOR_HEAD, WEAPON, DIGGER, FISHING_ROD, BREAKABLE, BOW};


   private EnchantmentSlotType(String var1, int var2) {}

   public boolean a(Item var1) {
      if(this == ALL) {
         return true;
      } else if(this == BREAKABLE && var1.m()) {
         return true;
      } else if(var1 instanceof ItemArmor) {
         if(this == ARMOR) {
            return true;
         } else {
            ItemArmor var2 = (ItemArmor)var1;
            return var2.b == 0?this == ARMOR_HEAD:(var2.b == 2?this == ARMOR_LEGS:(var2.b == 1?this == ARMOR_TORSO:(var2.b == 3?this == ARMOR_FEET:false)));
         }
      } else {
         return var1 instanceof ItemSword?this == WEAPON:(var1 instanceof aks?this == DIGGER:(var1 instanceof ItemBow?this == BOW:(var1 instanceof ItemFishingRod?this == FISHING_ROD:false)));
      }
   }

}
