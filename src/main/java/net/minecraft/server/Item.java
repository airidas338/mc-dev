package net.minecraft.server;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;

import java.util.Map;
import java.util.Random;
import java.util.UUID;

public class Item {

   public static final ev e = new ev();
   private static final Map a = Maps.newHashMap();
   protected static final UUID f = UUID.fromString("CB3F55D3-645C-4F38-A497-9C13A33DB5CF");
   private CreativeModeTab b;
   protected static Random g = new Random();
   protected int h = 64;
   private int c;
   protected boolean i;
   protected boolean j;
   private Item d;
   private String k;
   private String l;


   public static int b(Item var0) {
      return var0 == null?0:e.b(var0);
   }

   public static Item b(int var0) {
      return (Item)e.a(var0);
   }

   public static Item a(Block var0) {
      return (Item)a.get(var0);
   }

   public static Item d(String var0) {
      Item var1 = (Item)e.a(new RegistryMaterials(var0));
      if(var1 == null) {
         try {
            return b(Integer.parseInt(var0));
         } catch (NumberFormatException var3) {
            ;
         }
      }

      return var1;
   }

   public boolean a(NBTTagCompound var1) {
      return false;
   }

   public Item c(int var1) {
      this.h = var1;
      return this;
   }

   public boolean a(ItemStack var1, EntityHuman var2, World var3, Location var4, EnumFacing var5, float var6, float var7, float var8) {
      return false;
   }

   public float a(ItemStack var1, Block var2) {
      return 1.0F;
   }

   public ItemStack a(ItemStack var1, World var2, EntityHuman var3) {
      return var1;
   }

   public ItemStack b(ItemStack var1, World var2, EntityHuman var3) {
      return var1;
   }

   public int j() {
      return this.h;
   }

   public int a(int var1) {
      return 0;
   }

   public boolean k() {
      return this.j;
   }

   protected Item a(boolean var1) {
      this.j = var1;
      return this;
   }

   public int l() {
      return this.c;
   }

   protected Item d(int var1) {
      this.c = var1;
      return this;
   }

   public boolean m() {
      return this.c > 0 && !this.j;
   }

   public boolean a(ItemStack var1, EntityLiving var2, EntityLiving var3) {
      return false;
   }

   public boolean a(ItemStack var1, World var2, Block var3, Location var4, EntityLiving var5) {
      return false;
   }

   public boolean b(Block var1) {
      return false;
   }

   public boolean a(ItemStack var1, EntityHuman var2, EntityLiving var3) {
      return false;
   }

   public Item n() {
      this.i = true;
      return this;
   }

   public Item c(String var1) {
      this.l = var1;
      return this;
   }

   public String k(ItemStack var1) {
      String var2 = this.e_(var1);
      return var2 == null?"":fi.a(var2);
   }

   public String a() {
      return "item." + this.l;
   }

   public String e_(ItemStack var1) {
      return "item." + this.l;
   }

   public Item c(Item var1) {
      this.d = var1;
      return this;
   }

   public boolean p() {
      return true;
   }

   public Item q() {
      return this.d;
   }

   public boolean r() {
      return this.d != null;
   }

   public void a(ItemStack var1, World var2, Entity var3, int var4, boolean var5) {}

   public void d(ItemStack var1, World var2, EntityHuman var3) {}

   public boolean f() {
      return false;
   }

   public ano e(ItemStack var1) {
      return ano.a;
   }

   public int d(ItemStack var1) {
      return 0;
   }

   public void a(ItemStack var1, World var2, EntityHuman var3, int var4) {}

   protected Item e(String var1) {
      this.k = var1;
      return this;
   }

   public String j(ItemStack var1) {
      return this.k;
   }

   public boolean l(ItemStack var1) {
      return this.j(var1) != null;
   }

   public String a(ItemStack var1) {
      return ("" + fi.a(this.k(var1) + ".name")).trim();
   }

   public amx g(ItemStack var1) {
      return var1.w()?amx.c:amx.a;
   }

   public boolean f_(ItemStack var1) {
      return this.j() == 1 && this.m();
   }

   protected MovingObjectPosition a(World var1, EntityHuman var2, boolean var3) {
      float var4 = var2.B + (var2.z - var2.B);
      float var5 = var2.A + (var2.y - var2.A);
      double var6 = var2.p + (var2.s - var2.p);
      double var8 = var2.q + (var2.t - var2.q) + (double)var2.aR();
      double var10 = var2.r + (var2.u - var2.r);
      Vec3D var12 = new Vec3D(var6, var8, var10);
      float var13 = MathHelper.cos(-var5 * 0.017453292F - 3.1415927F);
      float var14 = MathHelper.sin(-var5 * 0.017453292F - 3.1415927F);
      float var15 = -MathHelper.cos(-var4 * 0.017453292F);
      float var16 = MathHelper.sin(-var4 * 0.017453292F);
      float var17 = var14 * var15;
      float var19 = var13 * var15;
      double var20 = 5.0D;
      Vec3D var22 = var12.b((double)var17 * var20, (double)var16 * var20, (double)var19 * var20);
      return var1.a(var12, var22, var3, !var3, false);
   }

   public int b() {
      return 0;
   }

   public Item a(CreativeModeTab var1) {
      this.b = var1;
      return this;
   }

   public boolean s() {
      return false;
   }

   public boolean a(ItemStack var1, ItemStack var2) {
      return false;
   }

   public Multimap i() {
      return HashMultimap.create();
   }

   public static void t() {
      a(Blocks.b, (Item)(new amr(Blocks.b, Blocks.b, new alr())).b("stone"));
      a((Block)Blocks.c, (Item)(new ann(Blocks.c, false)));
      a(Blocks.d, (Item)(new amr(Blocks.d, Blocks.d, new ama())).b("dirt"));
      c(Blocks.e);
      a(Blocks.f, (Item)(new amr(Blocks.f, Blocks.f, new amb())).b("wood"));
      a(Blocks.g, (Item)(new amr(Blocks.g, Blocks.g, new amc())).b("sapling"));
      c(Blocks.h);
      a((Block)Blocks.m, (Item)(new amr(Blocks.m, Blocks.m, new amd())).b("sand"));
      c(Blocks.n);
      c(Blocks.o);
      c(Blocks.p);
      c(Blocks.q);
      a(Blocks.r, (Item)(new amr(Blocks.r, Blocks.r, new ame())).b("log"));
      a(Blocks.s, (Item)(new amr(Blocks.s, Blocks.s, new amf())).b("log"));
      a((Block)Blocks.t, (Item)(new amm(Blocks.t)).b("leaves"));
      a((Block)Blocks.u, (Item)(new amm(Blocks.u)).b("leaves"));
      a(Blocks.v, (Item)(new amr(Blocks.v, Blocks.v, new amg())).b("sponge"));
      c(Blocks.w);
      c(Blocks.x);
      c(Blocks.y);
      c(Blocks.z);
      a(Blocks.A, (Item)(new amr(Blocks.A, Blocks.A, new amh())).b("sandStone"));
      c(Blocks.B);
      c(Blocks.D);
      c(Blocks.E);
      a((Block)Blocks.F, (Item)(new amv(Blocks.F)));
      c(Blocks.G);
      a((Block)Blocks.H, (Item)(new ann(Blocks.H, true)).a(new String[]{"shrub", "grass", "fern"}));
      c((Block)Blocks.I);
      a((Block)Blocks.J, (Item)(new amv(Blocks.J)));
      a(Blocks.L, (Item)(new akx(Blocks.L)).b("cloth"));
      a((Block)Blocks.N, (Item)(new amr(Blocks.N, Blocks.N, new als())).b("flower"));
      a((Block)Blocks.O, (Item)(new amr(Blocks.O, Blocks.O, new alt())).b("rose"));
      c((Block)Blocks.P);
      c((Block)Blocks.Q);
      c(Blocks.R);
      c(Blocks.S);
      a((Block)Blocks.U, (Item)(new ani(Blocks.U, Blocks.U, Blocks.T)).b("stoneSlab"));
      c(Blocks.V);
      c(Blocks.W);
      c(Blocks.X);
      c(Blocks.Y);
      c(Blocks.Z);
      c(Blocks.aa);
      c(Blocks.ac);
      c(Blocks.ad);
      c((Block)Blocks.ae);
      c(Blocks.ag);
      c(Blocks.ah);
      c(Blocks.ai);
      c(Blocks.ak);
      c(Blocks.al);
      c(Blocks.am);
      c(Blocks.au);
      c(Blocks.av);
      c(Blocks.aw);
      c(Blocks.ay);
      c(Blocks.az);
      c(Blocks.aB);
      c(Blocks.aC);
      c(Blocks.aF);
      c(Blocks.aG);
      a(Blocks.aH, (Item)(new anj(Blocks.aH)));
      c(Blocks.aI);
      c(Blocks.aJ);
      c((Block)Blocks.aK);
      c(Blocks.aL);
      c(Blocks.aN);
      c(Blocks.aO);
      c(Blocks.aP);
      c(Blocks.aQ);
      c(Blocks.aR);
      c(Blocks.aS);
      c(Blocks.aT);
      c(Blocks.aU);
      c(Blocks.aV);
      c(Blocks.aW);
      c(Blocks.aX);
      c(Blocks.aZ);
      c(Blocks.bd);
      a(Blocks.be, (Item)(new amr(Blocks.be, Blocks.be, new alu())).b("monsterStoneEgg"));
      a(Blocks.bf, (Item)(new amr(Blocks.bf, Blocks.bf, new alv())).b("stonebricksmooth"));
      c(Blocks.bg);
      c(Blocks.bh);
      c(Blocks.bi);
      c(Blocks.bj);
      c(Blocks.bk);
      a(Blocks.bn, (Item)(new ann(Blocks.bn, false)));
      c(Blocks.bo);
      c(Blocks.bp);
      c(Blocks.bq);
      c(Blocks.br);
      c(Blocks.bs);
      c(Blocks.bt);
      c(Blocks.bu);
      c(Blocks.bv);
      c((Block)Blocks.bw);
      a(Blocks.bx, (Item)(new anp(Blocks.bx)));
      c(Blocks.by);
      c(Blocks.bz);
      c(Blocks.bA);
      c(Blocks.bC);
      c(Blocks.bG);
      c(Blocks.WHITESTONE);
      c(Blocks.bI);
      c(Blocks.bJ);
      a((Block)Blocks.bM, (Item)(new ani(Blocks.bM, Blocks.bM, Blocks.bL)).b("woodSlab"));
      c(Blocks.bO);
      c(Blocks.bP);
      c(Blocks.bQ);
      c((Block)Blocks.bR);
      c(Blocks.bT);
      c(Blocks.bU);
      c(Blocks.bV);
      c(Blocks.bW);
      c(Blocks.bX);
      c((Block)Blocks.bY);
      a(Blocks.bZ, (Item)(new amr(Blocks.bZ, Blocks.bZ, new alw())).b("cobbleWall"));
      c(Blocks.cd);
      a(Blocks.cf, (Item)(new ajm(Blocks.cf)).b("anvil"));
      c(Blocks.cg);
      c(Blocks.ch);
      c(Blocks.ci);
      c((Block)Blocks.cl);
      c(Blocks.cn);
      c(Blocks.co);
      c((Block)Blocks.cp);
      a(Blocks.cq, (Item)(new amr(Blocks.cq, Blocks.cq, new String[]{"default", "chiseled", "lines"})).b("quartzBlock"));
      c(Blocks.cr);
      c(Blocks.cs);
      c(Blocks.ct);
      a(Blocks.cu, (Item)(new akx(Blocks.cu)).b("clayHardenedStained"));
      c(Blocks.cv);
      c(Blocks.cw);
      c(Blocks.cx);
      a(Blocks.cy, (Item)(new akx(Blocks.cy)).b("woolCarpet"));
      c(Blocks.cz);
      c(Blocks.cA);
      c(Blocks.cB);
      c(Blocks.cC);
      c(Blocks.cD);
      c(Blocks.cE);
      a((Block)Blocks.cF, (Item)(new aku(Blocks.cF, Blocks.cF, new alx())).b("doublePlant"));
      a((Block)Blocks.cG, (Item)(new akx(Blocks.cG)).b("stainedGlass"));
      a((Block)Blocks.cH, (Item)(new akx(Blocks.cH)).b("stainedGlassPane"));
      a(Blocks.cI, (Item)(new amr(Blocks.cI, Blocks.cI, new aly())).b("prismarine"));
      c(Blocks.cJ);
      a(Blocks.cM, (Item)(new amr(Blocks.cM, Blocks.cM, new alz())).b("redSandStone"));
      c(Blocks.cN);
      a((Block)Blocks.cP, (Item)(new ani(Blocks.cP, Blocks.cP, Blocks.cO)).b("stoneSlab2"));
      a(256, "iron_shovel", (new ane(ami.c)).c("shovelIron"));
      a(257, "iron_pickaxe", (new amu(ami.c)).c("pickaxeIron"));
      a(258, "iron_axe", (new ajr(ami.c)).c("hatchetIron"));
      a(259, "flint_and_steel", (new alk()).c("flintAndSteel"));
      a(260, "apple", (new all(4, 0.3F, false)).c("apple"));
      a(261, "bow", (new ItemBow()).c("bow"));
      a(262, "arrow", (new Item()).c("arrow").a(CreativeModeTab.j));
      a(263, "coal", (new akd()).c("coal"));
      a(264, "diamond", (new Item()).c("diamond").a(CreativeModeTab.l));
      a(265, "iron_ingot", (new Item()).c("ingotIron").a(CreativeModeTab.l));
      a(266, "gold_ingot", (new Item()).c("ingotGold").a(CreativeModeTab.l));
      a(267, "iron_sword", (new anm(ami.c)).c("swordIron"));
      a(268, "wooden_sword", (new anm(ami.a)).c("swordWood"));
      a(269, "wooden_shovel", (new ane(ami.a)).c("shovelWood"));
      a(270, "wooden_pickaxe", (new amu(ami.a)).c("pickaxeWood"));
      a(271, "wooden_axe", (new ajr(ami.a)).c("hatchetWood"));
      a(272, "stone_sword", (new anm(ami.b)).c("swordStone"));
      a(273, "stone_shovel", (new ane(ami.b)).c("shovelStone"));
      a(274, "stone_pickaxe", (new amu(ami.b)).c("pickaxeStone"));
      a(275, "stone_axe", (new ajr(ami.b)).c("hatchetStone"));
      a(276, "diamond_sword", (new anm(ami.d)).c("swordDiamond"));
      a(277, "diamond_shovel", (new ane(ami.d)).c("shovelDiamond"));
      a(278, "diamond_pickaxe", (new amu(ami.d)).c("pickaxeDiamond"));
      a(279, "diamond_axe", (new ajr(ami.d)).c("hatchetDiamond"));
      a(280, "stick", (new Item()).n().c("stick").a(CreativeModeTab.l));
      a(281, "bowl", (new Item()).c("bowl").a(CreativeModeTab.l));
      a(282, "mushroom_stew", (new aka(6)).c("mushroomStew"));
      a(283, "golden_sword", (new anm(ami.e)).c("swordGold"));
      a(284, "golden_shovel", (new ane(ami.e)).c("shovelGold"));
      a(285, "golden_pickaxe", (new amu(ami.e)).c("pickaxeGold"));
      a(286, "golden_axe", (new ajr(ami.e)).c("hatchetGold"));
      a(287, "string", (new ajv(Blocks.bS)).c("string").a(CreativeModeTab.l));
      a(288, "feather", (new Item()).c("feather").a(CreativeModeTab.l));
      a(289, "gunpowder", (new Item()).c("sulphur").e(PotionBrewer.k).a(CreativeModeTab.l));
      a(290, "wooden_hoe", (new alo(ami.a)).c("hoeWood"));
      a(291, "stone_hoe", (new alo(ami.b)).c("hoeStone"));
      a(292, "iron_hoe", (new alo(ami.c)).c("hoeIron"));
      a(293, "diamond_hoe", (new alo(ami.d)).c("hoeDiamond"));
      a(294, "golden_hoe", (new alo(ami.e)).c("hoeGold"));
      a(295, "wheat_seeds", (new anc(Blocks.aj, Blocks.ak)).c("seeds"));
      a(296, "wheat", (new Item()).c("wheat").a(CreativeModeTab.l));
      a(297, "bread", (new all(5, 0.6F, false)).c("bread"));
      a(298, "leather_helmet", (new ItemArmor(ajp.a, 0, 0)).c("helmetCloth"));
      a(299, "leather_chestplate", (new ItemArmor(ajp.a, 0, 1)).c("chestplateCloth"));
      a(300, "leather_leggings", (new ItemArmor(ajp.a, 0, 2)).c("leggingsCloth"));
      a(301, "leather_boots", (new ItemArmor(ajp.a, 0, 3)).c("bootsCloth"));
      a(302, "chainmail_helmet", (new ItemArmor(ajp.b, 1, 0)).c("helmetChain"));
      a(303, "chainmail_chestplate", (new ItemArmor(ajp.b, 1, 1)).c("chestplateChain"));
      a(304, "chainmail_leggings", (new ItemArmor(ajp.b, 1, 2)).c("leggingsChain"));
      a(305, "chainmail_boots", (new ItemArmor(ajp.b, 1, 3)).c("bootsChain"));
      a(306, "iron_helmet", (new ItemArmor(ajp.c, 2, 0)).c("helmetIron"));
      a(307, "iron_chestplate", (new ItemArmor(ajp.c, 2, 1)).c("chestplateIron"));
      a(308, "iron_leggings", (new ItemArmor(ajp.c, 2, 2)).c("leggingsIron"));
      a(309, "iron_boots", (new ItemArmor(ajp.c, 2, 3)).c("bootsIron"));
      a(310, "diamond_helmet", (new ItemArmor(ajp.e, 3, 0)).c("helmetDiamond"));
      a(311, "diamond_chestplate", (new ItemArmor(ajp.e, 3, 1)).c("chestplateDiamond"));
      a(312, "diamond_leggings", (new ItemArmor(ajp.e, 3, 2)).c("leggingsDiamond"));
      a(313, "diamond_boots", (new ItemArmor(ajp.e, 3, 3)).c("bootsDiamond"));
      a(314, "golden_helmet", (new ItemArmor(ajp.d, 4, 0)).c("helmetGold"));
      a(315, "golden_chestplate", (new ItemArmor(ajp.d, 4, 1)).c("chestplateGold"));
      a(316, "golden_leggings", (new ItemArmor(ajp.d, 4, 2)).c("leggingsGold"));
      a(317, "golden_boots", (new ItemArmor(ajp.d, 4, 3)).c("bootsGold"));
      a(318, "flint", (new Item()).c("flint").a(CreativeModeTab.l));
      a(319, "porkchop", (new all(3, 0.3F, true)).c("porkchopRaw"));
      a(320, "cooked_porkchop", (new all(8, 0.8F, true)).c("porkchopCooked"));
      a(321, "painting", (new aln(EntityPainting.class)).c("painting"));
      a(322, "golden_apple", (new alm(4, 1.2F, false)).h().a(MobEffectList.l.H, 5, 1, 1.0F).c("appleGold"));
      a(323, "sign", (new anf()).c("sign"));
      a(324, "wooden_door", (new akt(Blocks.ao)).c("doorOak"));
      Item var0 = (new akb(Blocks.AIR)).c("bucket").c(16);
      a(325, "bucket", var0);
      a(326, "water_bucket", (new akb(Blocks.i)).c("bucketWater").c(var0));
      a(327, "lava_bucket", (new akb(Blocks.k)).c("bucketLava").c(var0));
      a(328, "minecart", (new amp(EnumMinecartType.RIDEABLE)).c("minecart"));
      a(329, "saddle", (new ana()).c("saddle"));
      a(330, "iron_door", (new akt(Blocks.aA)).c("doorIron"));
      a(331, "redstone", (new amz()).c("redstone").e(PotionBrewer.i));
      a(332, "snowball", (new ank()).c("snowball"));
      a(333, "boat", (new ajw()).c("boat"));
      a(334, "leather", (new Item()).c("leather").a(CreativeModeTab.l));
      a(335, "milk_bucket", (new amo()).c("milk").c(var0));
      a(336, "brick", (new Item()).c("brick").a(CreativeModeTab.l));
      a(337, "clay_ball", (new Item()).c("clay").a(CreativeModeTab.l));
      a(338, "reeds", (new ajv(Blocks.aM)).c("reeds").a(CreativeModeTab.l));
      a(339, "paper", (new Item()).c("paper").a(CreativeModeTab.f));
      a(340, "book", (new ajx()).c("book").a(CreativeModeTab.f));
      a(341, "slime_ball", (new Item()).c("slimeball").a(CreativeModeTab.f));
      a(342, "chest_minecart", (new amp(EnumMinecartType.CHEST)).c("minecartChest"));
      a(343, "furnace_minecart", (new amp(EnumMinecartType.FURNACE)).c("minecartFurnace"));
      a(344, "egg", (new aky()).c("egg"));
      a(345, "compass", (new Item()).c("compass").a(CreativeModeTab.i));
      a(346, "fishing_rod", (new ItemFishingRod()).c("fishingRod"));
      a(347, "clock", (new Item()).c("clock").a(CreativeModeTab.i));
      a(348, "glowstone_dust", (new Item()).c("yellowDust").e(PotionBrewer.j).a(CreativeModeTab.l));
      a(349, "fish", (new alh(false)).c("fish").a(true));
      a(350, "cooked_fish", (new alh(true)).c("fish").a(true));
      a(351, "dye", (new akw()).c("dyePowder"));
      a(352, "bone", (new Item()).c("bone").n().a(CreativeModeTab.f));
      a(353, "sugar", (new Item()).c("sugar").e(PotionBrewer.b).a(CreativeModeTab.l));
      a(354, "cake", (new ajv(Blocks.ba)).c(1).c("cake").a(CreativeModeTab.h));
      a(355, "bed", (new ajt()).c(1).c("bed"));
      a(356, "repeater", (new ajv(Blocks.bb)).c("diode").a(CreativeModeTab.d));
      a(357, "cookie", (new all(2, 0.1F, false)).c("cookie"));
      a(358, "filled_map", (new ItemWorldMap()).c("map"));
      a(359, "shears", (new ItemShears()).c("shears"));
      a(360, "melon", (new all(2, 0.3F, false)).c("melon"));
      a(361, "pumpkin_seeds", (new anc(Blocks.bl, Blocks.ak)).c("seeds_pumpkin"));
      a(362, "melon_seeds", (new anc(Blocks.bm, Blocks.ak)).c("seeds_melon"));
      a(363, "beef", (new all(3, 0.3F, true)).c("beefRaw"));
      a(364, "cooked_beef", (new all(8, 0.8F, true)).c("beefCooked"));
      a(365, "chicken", (new all(2, 0.3F, true)).a(MobEffectList.s.H, 30, 0, 0.3F).c("chickenRaw"));
      a(366, "cooked_chicken", (new all(6, 0.6F, true)).c("chickenCooked"));
      a(367, "rotten_flesh", (new all(4, 0.1F, true)).a(MobEffectList.s.H, 30, 0, 0.8F).c("rottenFlesh"));
      a(368, "ender_pearl", (new alc()).c("enderPearl"));
      a(369, "blaze_rod", (new Item()).c("blazeRod").a(CreativeModeTab.l).n());
      a(370, "ghast_tear", (new Item()).c("ghastTear").e(PotionBrewer.c).a(CreativeModeTab.k));
      a(371, "gold_nugget", (new Item()).c("goldNugget").a(CreativeModeTab.l));
      a(372, "nether_wart", (new anc(Blocks.bB, Blocks.aW)).c("netherStalkSeeds").e("+4"));
      a(373, "potion", (new ItemPotion()).c("potion"));
      a(374, "glass_bottle", (new ajy()).c("glassBottle"));
      a(375, "spider_eye", (new all(2, 0.8F, false)).a(MobEffectList.u.H, 5, 0, 1.0F).c("spiderEye").e(PotionBrewer.d));
      a(376, "fermented_spider_eye", (new Item()).c("fermentedSpiderEye").e(PotionBrewer.e).a(CreativeModeTab.k));
      a(377, "blaze_powder", (new Item()).c("blazePowder").e(PotionBrewer.g).a(CreativeModeTab.k));
      a(378, "magma_cream", (new Item()).c("magmaCream").e(PotionBrewer.h).a(CreativeModeTab.k));
      a(379, "brewing_stand", (new ajv(Blocks.bD)).c("brewingStand").a(CreativeModeTab.k));
      a(380, "cauldron", (new ajv(Blocks.bE)).c("cauldron").a(CreativeModeTab.k));
      a(381, "ender_eye", (new alb()).c("eyeOfEnder"));
      a(382, "speckled_melon", (new Item()).c("speckledMelon").e(PotionBrewer.f).a(CreativeModeTab.k));
      a(383, "spawn_egg", (new anl()).c("monsterPlacer"));
      a(384, "experience_bottle", (new ald()).c("expBottle"));
      a(385, "fire_charge", (new ale()).c("fireball"));
      a(386, "writable_book", (new anq()).c("writingBook").a(CreativeModeTab.f));
      a(387, "written_book", (new anr()).c("writtenBook").c(16));
      a(388, "emerald", (new Item()).c("emerald").a(CreativeModeTab.l));
      a(389, "item_frame", (new aln(EntityItemFrame.class)).c("frame"));
      a(390, "flower_pot", (new ajv(Blocks.ca)).c("flowerPot").a(CreativeModeTab.c));
      a(391, "carrot", (new anb(3, 0.6F, Blocks.cb, Blocks.ak)).c("carrots"));
      a(392, "potato", (new anb(1, 0.3F, Blocks.cc, Blocks.ak)).c("potato"));
      a(393, "baked_potato", (new all(5, 0.6F, false)).c("potatoBaked"));
      a(394, "poisonous_potato", (new all(2, 0.3F, false)).a(MobEffectList.u.H, 5, 0, 0.6F).c("potatoPoisonous"));
      a(395, "map", (new ItemMapEmpty()).c("emptyMap"));
      a(396, "golden_carrot", (new all(6, 1.2F, false)).c("carrotGolden").e(PotionBrewer.l).a(CreativeModeTab.k));
      a(397, "skull", (new anh()).c("skull"));
      a(398, "carrot_on_a_stick", (new akc()).c("carrotOnAStick"));
      a(399, "nether_star", (new ang()).c("netherStar").a(CreativeModeTab.l));
      a(400, "pumpkin_pie", (new all(8, 0.3F, false)).c("pumpkinPie").a(CreativeModeTab.h));
      a(401, "fireworks", (new alg()).c("fireworks"));
      a(402, "firework_charge", (new alf()).c("fireworksCharge").a(CreativeModeTab.f));
      a(403, "enchanted_book", (new ItemEnchantedBook()).c(1).c("enchantedBook"));
      a(404, "comparator", (new ajv(Blocks.cj)).c("comparator").a(CreativeModeTab.d));
      a(405, "netherbrick", (new Item()).c("netherbrick").a(CreativeModeTab.l));
      a(406, "quartz", (new Item()).c("netherquartz").a(CreativeModeTab.l));
      a(407, "tnt_minecart", (new amp(EnumMinecartType.TNT)).c("minecartTnt"));
      a(408, "hopper_minecart", (new amp(EnumMinecartType.HOPPER)).c("minecartHopper"));
      a(409, "prismarine_shard", (new Item()).c("prismarineShard").a(CreativeModeTab.l));
      a(410, "prismarine_crystals", (new Item()).c("prismarineCrystals").a(CreativeModeTab.l));
      a(411, "rabbit", (new all(3, 0.3F, true)).c("rabbitRaw"));
      a(412, "cooked_rabbit", (new all(5, 0.6F, true)).c("rabbitCooked"));
      a(413, "rabbit_stew", (new aka(10)).c("rabbitStew"));
      a(414, "rabbit_foot", (new Item()).c("rabbitFoot").e(PotionBrewer.n).a(CreativeModeTab.k));
      a(415, "rabbit_hide", (new Item()).c("rabbitHide").a(CreativeModeTab.l));
      a(416, "armor_stand", (new ItemArmorStand()).c("armorStand").c(16));
      a(417, "iron_horse_armor", (new Item()).c("horsearmormetal").c(1).a(CreativeModeTab.f));
      a(418, "golden_horse_armor", (new Item()).c("horsearmorgold").c(1).a(CreativeModeTab.f));
      a(419, "diamond_horse_armor", (new Item()).c("horsearmordiamond").c(1).a(CreativeModeTab.f));
      a(420, "lead", (new aml()).c("leash"));
      a(421, "name_tag", (new amt()).c("nameTag"));
      a(422, "command_block_minecart", (new amp(EnumMinecartType.COMMAND_BLOCK)).c("minecartCommandBlock").a((CreativeModeTab)null));
      a(423, "mutton", (new all(2, 0.3F, true)).c("muttonRaw"));
      a(424, "cooked_mutton", (new all(6, 0.8F, true)).c("muttonCooked"));
      a(425, "banner", (new ajs()).b("banner"));
      a(427, "spruce_door", (new akt(Blocks.ap)).c("doorSpruce"));
      a(428, "birch_door", (new akt(Blocks.aq)).c("doorBirch"));
      a(429, "jungle_door", (new akt(Blocks.ar)).c("doorJungle"));
      a(430, "acacia_door", (new akt(Blocks.as)).c("doorAcacia"));
      a(431, "dark_oak_door", (new akt(Blocks.at)).c("doorDarkOak"));
      a(2256, "record_13", (new amy("13")).c("record"));
      a(2257, "record_cat", (new amy("cat")).c("record"));
      a(2258, "record_blocks", (new amy("blocks")).c("record"));
      a(2259, "record_chirp", (new amy("chirp")).c("record"));
      a(2260, "record_far", (new amy("far")).c("record"));
      a(2261, "record_mall", (new amy("mall")).c("record"));
      a(2262, "record_mellohi", (new amy("mellohi")).c("record"));
      a(2263, "record_stal", (new amy("stal")).c("record"));
      a(2264, "record_strad", (new amy("strad")).c("record"));
      a(2265, "record_ward", (new amy("ward")).c("record"));
      a(2266, "record_11", (new amy("11")).c("record"));
      a(2267, "record_wait", (new amy("wait")).c("record"));
   }

   private static void c(Block var0) {
      a(var0, (Item)(new aju(var0)));
   }

   protected static void a(Block var0, Item var1) {
      a(Block.a(var0), (RegistryMaterials)Block.c.c(var0), var1);
      a.put(var0, var1);
   }

   private static void a(int var0, String var1, Item var2) {
      a(var0, new RegistryMaterials(var1), var2);
   }

   private static void a(int var0, RegistryMaterials var1, Item var2) {
      e.a(var0, var1, var2);
   }

}
