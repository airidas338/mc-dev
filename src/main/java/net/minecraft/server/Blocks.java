package net.minecraft.server;

public class Blocks {

   public static final Block AIR;
   public static final Block b;
   public static final BlockGrass c;
   public static final Block d;
   public static final Block e;
   public static final Block f;
   public static final Block g;
   public static final Block h;
   public static final BlockFlowing i;
   public static final BlockStationary j;
   public static final BlockFlowing k;
   public static final BlockStationary l;
   public static final BlockSand m;
   public static final Block n;
   public static final Block o;
   public static final Block p;
   public static final Block q;
   public static final Block r;
   public static final Block s;
   public static final BlockLeaves t;
   public static final BlockLeaves u;
   public static final Block v;
   public static final Block w;
   public static final Block x;
   public static final Block y;
   public static final Block z;
   public static final Block A;
   public static final Block B;
   public static final Block C;
   public static final Block D;
   public static final Block E;
   public static final BlockPiston F;
   public static final Block G;
   public static final BlockLongGrass H;
   public static final BlockDeadBush I;
   public static final BlockPiston J;
   public static final BlockPistonExtension K;
   public static final Block L;
   public static final BlockPistonMoving M;
   public static final BlockFlowers N;
   public static final BlockFlowers O;
   public static final BlockPlant P;
   public static final BlockPlant Q;
   public static final Block R;
   public static final Block S;
   public static final BlockStepAbstract T;
   public static final BlockStepAbstract U;
   public static final Block V;
   public static final Block W;
   public static final Block X;
   public static final Block Y;
   public static final Block Z;
   public static final Block aa;
   public static final BlockFire ab;
   public static final Block ac;
   public static final Block ad;
   public static final BlockChest ae;
   public static final BlockRedstoneWire af;
   public static final Block ag;
   public static final Block ah;
   public static final Block ai;
   public static final Block aj;
   public static final Block ak;
   public static final Block al;
   public static final Block am;
   public static final Block an;
   public static final Block ao;
   public static final Block ap;
   public static final Block aq;
   public static final Block ar;
   public static final Block as;
   public static final Block at;
   public static final Block au;
   public static final Block av;
   public static final Block aw;
   public static final Block ax;
   public static final Block ay;
   public static final Block az;
   public static final Block aA;
   public static final Block aB;
   public static final Block aC;
   public static final Block aD;
   public static final Block aE;
   public static final Block aF;
   public static final Block aG;
   public static final Block aH;
   public static final Block aI;
   public static final Block aJ;
   public static final BlockCactus aK;
   public static final Block aL;
   public static final BlockReed aM;
   public static final Block aN;
   public static final Block aO;
   public static final Block aP;
   public static final Block aQ;
   public static final Block aR;
   public static final Block aS;
   public static final Block aT;
   public static final Block aU;
   public static final Block aV;
   public static final Block aW;
   public static final Block aX;
   public static final BlockPortal aY;
   public static final Block aZ;
   public static final Block ba;
   public static final BlockRepeater bb;
   public static final BlockRepeater bc;
   public static final Block bd;
   public static final Block be;
   public static final Block bf;
   public static final Block bg;
   public static final Block bh;
   public static final Block bi;
   public static final Block bj;
   public static final Block bk;
   public static final Block bl;
   public static final Block bm;
   public static final Block bn;
   public static final Block bo;
   public static final Block bp;
   public static final Block bq;
   public static final Block br;
   public static final Block bs;
   public static final Block bt;
   public static final Block bu;
   public static final Block bv;
   public static final BlockMycel bw;
   public static final Block bx;
   public static final Block by;
   public static final Block bz;
   public static final Block bA;
   public static final Block bB;
   public static final Block bC;
   public static final Block bD;
   public static final BlockCauldron bE;
   public static final Block bF;
   public static final Block bG;
   public static final Block WHITESTONE;
   public static final Block bI;
   public static final Block bJ;
   public static final Block bK;
   public static final BlockStepAbstract bL;
   public static final BlockStepAbstract bM;
   public static final Block bN;
   public static final Block bO;
   public static final Block bP;
   public static final Block bQ;
   public static final BlockTripwireHook bR;
   public static final Block bS;
   public static final Block bT;
   public static final Block bU;
   public static final Block bV;
   public static final Block bW;
   public static final Block bX;
   public static final BlockBeacon bY;
   public static final Block bZ;
   public static final Block ca;
   public static final Block cb;
   public static final Block cc;
   public static final Block cd;
   public static final BlockSkull ce;
   public static final Block cf;
   public static final Block cg;
   public static final Block ch;
   public static final Block ci;
   public static final BlockRedstoneComparator cj;
   public static final BlockRedstoneComparator ck;
   public static final BlockDaylightDetector cl;
   public static final BlockDaylightDetector cm;
   public static final Block cn;
   public static final Block co;
   public static final BlockHopper cp;
   public static final Block cq;
   public static final Block cr;
   public static final Block cs;
   public static final Block ct;
   public static final Block cu;
   public static final Block cv;
   public static final Block cw;
   public static final Block cx;
   public static final Block cy;
   public static final Block cz;
   public static final Block cA;
   public static final Block cB;
   public static final Block cC;
   public static final Block cD;
   public static final Block cE;
   public static final BlockTallPlant cF;
   public static final BlockStainedGlass cG;
   public static final BlockStainedGlassPane cH;
   public static final Block cI;
   public static final Block cJ;
   public static final Block cK;
   public static final Block cL;
   public static final Block cM;
   public static final Block cN;
   public static final BlockStepAbstract cO;
   public static final BlockStepAbstract cP;


   private static Block a(String var0) {
      return (Block)Block.c.a(new RegistryMaterials(var0));
   }

   static {
      if(!DispenserRegistry.a()) {
         throw new RuntimeException("Accessed Blocks before Bootstrap!");
      } else {
         AIR = a("air");
         b = a("stone");
         c = (BlockGrass)a("grass");
         d = a("dirt");
         e = a("cobblestone");
         f = a("planks");
         g = a("sapling");
         h = a("bedrock");
         i = (BlockFlowing)a("flowing_water");
         j = (BlockStationary)a("water");
         k = (BlockFlowing)a("flowing_lava");
         l = (BlockStationary)a("lava");
         m = (BlockSand)a("sand");
         n = a("gravel");
         o = a("gold_ore");
         p = a("iron_ore");
         q = a("coal_ore");
         r = a("log");
         s = a("log2");
         t = (BlockLeaves)a("leaves");
         u = (BlockLeaves)a("leaves2");
         v = a("sponge");
         w = a("glass");
         x = a("lapis_ore");
         y = a("lapis_block");
         z = a("dispenser");
         A = a("sandstone");
         B = a("noteblock");
         C = a("bed");
         D = a("golden_rail");
         E = a("detector_rail");
         F = (BlockPiston)a("sticky_piston");
         G = a("web");
         H = (BlockLongGrass)a("tallgrass");
         I = (BlockDeadBush)a("deadbush");
         J = (BlockPiston)a("piston");
         K = (BlockPistonExtension)a("piston_head");
         L = a("wool");
         M = (BlockPistonMoving)a("piston_extension");
         N = (BlockFlowers)a("yellow_flower");
         O = (BlockFlowers)a("red_flower");
         P = (BlockPlant)a("brown_mushroom");
         Q = (BlockPlant)a("red_mushroom");
         R = a("gold_block");
         S = a("iron_block");
         T = (BlockStepAbstract)a("double_stone_slab");
         U = (BlockStepAbstract)a("stone_slab");
         V = a("brick_block");
         W = a("tnt");
         X = a("bookshelf");
         Y = a("mossy_cobblestone");
         Z = a("obsidian");
         aa = a("torch");
         ab = (BlockFire)a("fire");
         ac = a("mob_spawner");
         ad = a("oak_stairs");
         ae = (BlockChest)a("chest");
         af = (BlockRedstoneWire)a("redstone_wire");
         ag = a("diamond_ore");
         ah = a("diamond_block");
         ai = a("crafting_table");
         aj = a("wheat");
         ak = a("farmland");
         al = a("furnace");
         am = a("lit_furnace");
         an = a("standing_sign");
         ao = a("wooden_door");
         ap = a("spruce_door");
         aq = a("birch_door");
         ar = a("jungle_door");
         as = a("acacia_door");
         at = a("dark_oak_door");
         au = a("ladder");
         av = a("rail");
         aw = a("stone_stairs");
         ax = a("wall_sign");
         ay = a("lever");
         az = a("stone_pressure_plate");
         aA = a("iron_door");
         aB = a("wooden_pressure_plate");
         aC = a("redstone_ore");
         aD = a("lit_redstone_ore");
         aE = a("unlit_redstone_torch");
         aF = a("redstone_torch");
         aG = a("stone_button");
         aH = a("snow_layer");
         aI = a("ice");
         aJ = a("snow");
         aK = (BlockCactus)a("cactus");
         aL = a("clay");
         aM = (BlockReed)a("reeds");
         aN = a("jukebox");
         aO = a("fence");
         aP = a("spruce_fence");
         aQ = a("birch_fence");
         aR = a("jungle_fence");
         aS = a("dark_oak_fence");
         aT = a("acacia_fence");
         aU = a("pumpkin");
         aV = a("netherrack");
         aW = a("soul_sand");
         aX = a("glowstone");
         aY = (BlockPortal)a("portal");
         aZ = a("lit_pumpkin");
         ba = a("cake");
         bb = (BlockRepeater)a("unpowered_repeater");
         bc = (BlockRepeater)a("powered_repeater");
         bd = a("trapdoor");
         be = a("monster_egg");
         bf = a("stonebrick");
         bg = a("brown_mushroom_block");
         bh = a("red_mushroom_block");
         bi = a("iron_bars");
         bj = a("glass_pane");
         bk = a("melon_block");
         bl = a("pumpkin_stem");
         bm = a("melon_stem");
         bn = a("vine");
         bo = a("fence_gate");
         bp = a("spruce_fence_gate");
         bq = a("birch_fence_gate");
         br = a("jungle_fence_gate");
         bs = a("dark_oak_fence_gate");
         bt = a("acacia_fence_gate");
         bu = a("brick_stairs");
         bv = a("stone_brick_stairs");
         bw = (BlockMycel)a("mycelium");
         bx = a("waterlily");
         by = a("nether_brick");
         bz = a("nether_brick_fence");
         bA = a("nether_brick_stairs");
         bB = a("nether_wart");
         bC = a("enchanting_table");
         bD = a("brewing_stand");
         bE = (BlockCauldron)a("cauldron");
         bF = a("end_portal");
         bG = a("end_portal_frame");
         WHITESTONE = a("end_stone");
         bI = a("dragon_egg");
         bJ = a("redstone_lamp");
         bK = a("lit_redstone_lamp");
         bL = (BlockStepAbstract)a("double_wooden_slab");
         bM = (BlockStepAbstract)a("wooden_slab");
         bN = a("cocoa");
         bO = a("sandstone_stairs");
         bP = a("emerald_ore");
         bQ = a("ender_chest");
         bR = (BlockTripwireHook)a("tripwire_hook");
         bS = a("tripwire");
         bT = a("emerald_block");
         bU = a("spruce_stairs");
         bV = a("birch_stairs");
         bW = a("jungle_stairs");
         bX = a("command_block");
         bY = (BlockBeacon)a("beacon");
         bZ = a("cobblestone_wall");
         ca = a("flower_pot");
         cb = a("carrots");
         cc = a("potatoes");
         cd = a("wooden_button");
         ce = (BlockSkull)a("skull");
         cf = a("anvil");
         cg = a("trapped_chest");
         ch = a("light_weighted_pressure_plate");
         ci = a("heavy_weighted_pressure_plate");
         cj = (BlockRedstoneComparator)a("unpowered_comparator");
         ck = (BlockRedstoneComparator)a("powered_comparator");
         cl = (BlockDaylightDetector)a("daylight_detector");
         cm = (BlockDaylightDetector)a("daylight_detector_inverted");
         cn = a("redstone_block");
         co = a("quartz_ore");
         cp = (BlockHopper)a("hopper");
         cq = a("quartz_block");
         cr = a("quartz_stairs");
         cs = a("activator_rail");
         ct = a("dropper");
         cu = a("stained_hardened_clay");
         cv = a("barrier");
         cw = a("iron_trapdoor");
         cx = a("hay_block");
         cy = a("carpet");
         cz = a("hardened_clay");
         cA = a("coal_block");
         cB = a("packed_ice");
         cC = a("acacia_stairs");
         cD = a("dark_oak_stairs");
         cE = a("slime");
         cF = (BlockTallPlant)a("double_plant");
         cG = (BlockStainedGlass)a("stained_glass");
         cH = (BlockStainedGlassPane)a("stained_glass_pane");
         cI = a("prismarine");
         cJ = a("sea_lantern");
         cK = a("standing_banner");
         cL = a("wall_banner");
         cM = a("red_sandstone");
         cN = a("red_sandstone_stairs");
         cO = (BlockStepAbstract)a("double_stone_slab2");
         cP = (BlockStepAbstract)a("stone_slab2");
      }
   }
}
