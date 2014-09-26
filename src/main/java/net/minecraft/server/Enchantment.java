package net.minecraft.server;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public abstract class Enchantment {

   private static final Enchantment[] a = new Enchantment[256];
   public static final Enchantment[] b;
   private static final Map E = Maps.newHashMap();
   public static final Enchantment PROTECTION_ENVIRONMENTAL = new EnchantmentProtection(0, new RegistryPrepender("protection"), 10, 0);
   public static final Enchantment PROTECTION_FIRE = new EnchantmentProtection(1, new RegistryPrepender("fire_protection"), 5, 1);
   public static final Enchantment PROTECTION_FALL = new EnchantmentProtection(2, new RegistryPrepender("feather_falling"), 5, 2);
   public static final Enchantment PROTECTION_EXPLOSIONS = new EnchantmentProtection(3, new RegistryPrepender("blast_protection"), 2, 3);
   public static final Enchantment PROTECTION_PROJECTILE = new EnchantmentProtection(4, new RegistryPrepender("projectile_protection"), 5, 4);
   public static final Enchantment OXYGEN = new EnchantmentOxygen(5, new RegistryPrepender("respiration"), 2);
   public static final Enchantment WATER_WORKER = new EnchantmentWaterWorker(6, new RegistryPrepender("aqua_affinity"), 2);
   public static final Enchantment THORNS = new EnchantmentThorns(7, new RegistryPrepender("thorns"), 1);
   public static final Enchantment DEPTH_STRIDER = new EnchantmentDepthStrider(8, new RegistryPrepender("depth_strider"), 2);
   public static final Enchantment DAMAGE_ALL = new EnchantmentWeaponDamage(16, new RegistryPrepender("sharpness"), 10, 0);
   public static final Enchantment DAMAGE_UNDEAD = new EnchantmentWeaponDamage(17, new RegistryPrepender("smite"), 5, 1);
   public static final Enchantment DAMAGE_ARTHROPODS = new EnchantmentWeaponDamage(18, new RegistryPrepender("bane_of_arthropods"), 5, 2);
   public static final Enchantment KNOCKBACK = new EnchantmentKnockback(19, new RegistryPrepender("knockback"), 5);
   public static final Enchantment FIRE_ASPECT = new EnchantmentFire(20, new RegistryPrepender("fire_aspect"), 2);
   public static final Enchantment LOOT_BONUS_MOBS = new EnchantmentLootBonus(21, new RegistryPrepender("looting"), 2, EnchantmentSlotType.WEAPON);
   public static final Enchantment DIG_SPEED = new EnchantmentDigging(32, new RegistryPrepender("efficiency"), 10);
   public static final Enchantment SILK_TOUCH = new EnchantmentSilkTouch(33, new RegistryPrepender("silk_touch"), 1);
   public static final Enchantment DURABILITY = new EnchantmentDurability(34, new RegistryPrepender("unbreaking"), 5);
   public static final Enchantment LOOT_BONUS_BLOCKS = new EnchantmentLootBonus(35, new RegistryPrepender("fortune"), 2, EnchantmentSlotType.DIGGER);
   public static final Enchantment ARROW_DAMAGE = new EnchantmentArrowDamage(48, new RegistryPrepender("power"), 10);
   public static final Enchantment ARROW_KNOCKBACK = new EnchantmentArrowKnockback(49, new RegistryPrepender("punch"), 2);
   public static final Enchantment ARROW_FIRE = new EnchantmentFlameArrows(50, new RegistryPrepender("flame"), 2);
   public static final Enchantment ARROW_INFINITE = new EnchantmentInfiniteArrows(51, new RegistryPrepender("infinity"), 1);
   public static final Enchantment LUCK = new EnchantmentLootBonus(61, new RegistryPrepender("luck_of_the_sea"), 2, EnchantmentSlotType.FISHING_ROD);
   public static final Enchantment LURE = new EnchantmentLure(62, new RegistryPrepender("lure"), 2, EnchantmentSlotType.FISHING_ROD);
   public final int id;
   private final int F;
   public EnchantmentSlotType C;
   protected String D;


   public static Enchantment c(int var0) {
      return var0 >= 0 && var0 < a.length?a[var0]:null;
   }

   protected Enchantment(int var1, RegistryPrepender var2, int var3, EnchantmentSlotType var4) {
      this.id = var1;
      this.F = var3;
      this.C = var4;
      if(a[var1] != null) {
         throw new IllegalArgumentException("Duplicate enchantment id!");
      } else {
         a[var1] = this;
         E.put(var2, this);
      }
   }

   public static Enchantment b(String var0) {
      return (Enchantment)E.get(new RegistryPrepender(var0));
   }

   public static String[] c() {
      String[] var0 = new String[E.size()];
      int var1 = 0;

      RegistryPrepender var3;
      for(Iterator var2 = E.keySet().iterator(); var2.hasNext(); var0[var1++] = var3.toString()) {
         var3 = (RegistryPrepender)var2.next();
      }

      return var0;
   }

   public int d() {
      return this.F;
   }

   public int e() {
      return 1;
   }

   public int b() {
      return 1;
   }

   public int a(int var1) {
      return 1 + var1 * 10;
   }

   public int b(int var1) {
      return this.a(var1) + 5;
   }

   public int a(int var1, DamageSource var2) {
      return 0;
   }

   public float a(int var1, xs var2) {
      return 0.0F;
   }

   public boolean a(Enchantment var1) {
      return this != var1;
   }

   public Enchantment c(String var1) {
      this.D = var1;
      return this;
   }

   public String a() {
      return "enchantment." + this.D;
   }

   public String d(int var1) {
      String var2 = LocaleI18n.get(this.a());
      return var2 + " " + LocaleI18n.get("enchantment.level." + var1);
   }

   public boolean a(ItemStack var1) {
      return this.C.a(var1.getItem());
   }

   public void a(EntityLiving var1, Entity var2, int var3) {}

   public void b(EntityLiving var1, Entity var2, int var3) {}

   static {
      ArrayList var0 = Lists.newArrayList();
      Enchantment[] var1 = a;
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         Enchantment var4 = var1[var3];
         if(var4 != null) {
            var0.add(var4);
         }
      }

      b = (Enchantment[])var0.toArray(new Enchantment[var0.size()]);
   }
}
