package teamrtg.rtg.mods.vanilla.biomes;

import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import teamrtg.rtg.util.noise.CellNoise;
import teamrtg.rtg.util.noise.OpenSimplexNoise;
import teamrtg.rtg.world.biome.terrain.TerrainBase;
import teamrtg.rtg.world.gen.ChunkProviderRTG;

public class RealisticBiomeVanillaFrozenOcean extends RealisticBiomeVanillaBase {

    public RealisticBiomeVanillaFrozenOcean(ChunkProviderRTG chunkProvider) {

        super(
                Biomes.FROZEN_OCEAN,
                Biomes.RIVER,
                chunkProvider
        );
        this.noLakes = true;
    }

    @Override
    protected TerrainBase initTerrain() {
        return new TerrainBase() {
            @Override
            public float generateNoise(OpenSimplexNoise simplex, CellNoise cell, int x, int y, float border, float river) {
                return terrainOcean(x, y, simplex, river, 50f);
            }
        };
    }


    @Override
    protected void initDecos() {

    }

    @Override
    protected void initProperties() {
        config.addBlock(config.MIX_BLOCK_TOP).setDefault(Blocks.GRAVEL.getDefaultState());
        this.config.WATER_POND_CHANCE.setDefault(0);
        this.config.LAVA_POND_CHANCE.setDefault(0);
        this.config.SURFACE_BLEED_OUT.setDefault(false);
    }
}
