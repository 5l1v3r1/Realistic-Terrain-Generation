/*******************************************************************************
 * Copyright 2014-2016, the Biomes O' Plenty Team
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * 
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package biomesoplenty.api.biome;

import biomesoplenty.api.biome.generation.GenerationManager;
import biomesoplenty.api.biome.generation.GeneratorStage;
import biomesoplenty.api.biome.generation.IGenerator;
import biomesoplenty.common.enums.BOPClimates;
import biomesoplenty.common.world.BOPWorldSettings;
import net.minecraft.world.biome.BiomeGenBase;

import java.util.Map;

public interface IExtendedBiome
{
    public void applySettings(BOPWorldSettings settings);
    
    public BiomeOwner getBiomeOwner();
    public void addGenerator(String name, GeneratorStage stage, IGenerator generator);
    public GenerationManager getGenerationManager();
    public Map<BOPClimates, Integer> getWeightMap();
    public void clearWeights();
    public void addWeight(BOPClimates climate, int weight);
    
    public int getBeachId();
    
    /**Get the base biome associated with this extension**/
    public BiomeGenBase getBaseBiome();
}
