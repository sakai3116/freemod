package com.FREEMOD.freemod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class AcidTank extends Block {
    public static final DirectionProperty FANCING = BlockStateProperties.HORIZONTAL_FACING;

    public AcidTank(Properties properties) {
        super(properties);
    }

    private static final VoxelShape SHAPE = Block.box(0,0,0,16,16,16);

    @Override
    public VoxelShape getShape(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos, CollisionContext pContext) {
        return SHAPE;
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FANCING,pContext.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, LevelAccessor level, BlockPos pos, Rotation direction) {
        return state.setValue(FANCING,direction.rotate(state.getValue(FANCING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FANCING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FANCING);
    }
}