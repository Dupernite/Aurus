package com.dupernite.aurus.block.custom;

import net.minecraft.block.*;
import net.minecraft.block.enums.ChestType;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class PotBlock extends HorizontalFacingBlock {
    public static final DirectionProperty FACING;

    public PotBlock(Settings settings) {
        super(settings);
    }

    private static final VoxelShape SHAPE_NORTH = Stream.of(
            Block.createCuboidShape(14, 6, 7, 16, 7, 9),
            Block.createCuboidShape(14, 1, 7, 16, 2, 9),
            Block.createCuboidShape(15, 2, 7, 16, 6, 9),
            Block.createCuboidShape(0, 6, 7, 2, 7, 9),
            Block.createCuboidShape(0, 1, 7, 2, 2, 9),
            Block.createCuboidShape(0, 2, 7, 1, 6, 9),
            Block.createCuboidShape(3, 0, 3, 13, 1, 13),
            Block.createCuboidShape(3, 1, 2, 13, 9, 3),
            Block.createCuboidShape(3, 1, 13, 13, 9, 14),
            Block.createCuboidShape(2, 1, 3, 3, 9, 13),
            Block.createCuboidShape(13, 1, 3, 14, 9, 13),
            Block.createCuboidShape(13, 2, 13, 14, 7, 14),
            Block.createCuboidShape(13, 2, 2, 14, 7, 3),
            Block.createCuboidShape(2, 2, 2, 3, 7, 3),
            Block.createCuboidShape(2, 2, 13, 3, 7, 14)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape SHAPE_WEST = Stream.of(
            Block.createCuboidShape(7, 6, 0, 9, 7, 2),
            Block.createCuboidShape(7, 1, 0, 9, 2, 2),
            Block.createCuboidShape(7, 2, 0, 9, 6, 1),
            Block.createCuboidShape(7, 6, 14, 9, 7, 16),
            Block.createCuboidShape(7, 1, 14, 9, 2, 16),
            Block.createCuboidShape(7, 2, 15, 9, 6, 16),
            Block.createCuboidShape(3, 0, 3, 13, 1, 13),
            Block.createCuboidShape(2, 1, 3, 3, 9, 13),
            Block.createCuboidShape(13, 1, 3, 14, 9, 13),
            Block.createCuboidShape(3, 1, 13, 13, 9, 14),
            Block.createCuboidShape(3, 1, 2, 13, 9, 3),
            Block.createCuboidShape(13, 2, 2, 14, 7, 3),
            Block.createCuboidShape(2, 2, 2, 3, 7, 3),
            Block.createCuboidShape(2, 2, 13, 3, 7, 14),
            Block.createCuboidShape(13, 2, 13, 14, 7, 14)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape SHAPE_SOUTH = Stream.of(
            Block.createCuboidShape(0, 6, 7, 2, 7, 9),
            Block.createCuboidShape(0, 1, 7, 2, 2, 9),
            Block.createCuboidShape(0, 2, 7, 1, 6, 9),
            Block.createCuboidShape(14, 6, 7, 16, 7, 9),
            Block.createCuboidShape(14, 1, 7, 16, 2, 9),
            Block.createCuboidShape(15, 2, 7, 16, 6, 9),
            Block.createCuboidShape(3, 0, 3, 13, 1, 13),
            Block.createCuboidShape(3, 1, 13, 13, 9, 14),
            Block.createCuboidShape(3, 1, 2, 13, 9, 3),
            Block.createCuboidShape(13, 1, 3, 14, 9, 13),
            Block.createCuboidShape(2, 1, 3, 3, 9, 13),
            Block.createCuboidShape(2, 2, 2, 3, 7, 3),
            Block.createCuboidShape(2, 2, 13, 3, 7, 14),
            Block.createCuboidShape(13, 2, 13, 14, 7, 14),
            Block.createCuboidShape(13, 2, 2, 14, 7, 3)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_EAST = Stream.of(
            Block.createCuboidShape(7, 6, 14, 9, 7, 16),
            Block.createCuboidShape(7, 1, 14, 9, 2, 16),
            Block.createCuboidShape(7, 2, 15, 9, 6, 16),
            Block.createCuboidShape(7, 6, 0, 9, 7, 2),
            Block.createCuboidShape(7, 1, 0, 9, 2, 2),
            Block.createCuboidShape(7, 2, 0, 9, 6, 1),
            Block.createCuboidShape(3, 0, 3, 13, 1, 13),
            Block.createCuboidShape(13, 1, 3, 14, 9, 13),
            Block.createCuboidShape(2, 1, 3, 3, 9, 13),
            Block.createCuboidShape(3, 1, 2, 13, 9, 3),
            Block.createCuboidShape(3, 1, 13, 13, 9, 14),
            Block.createCuboidShape(2, 2, 13, 3, 7, 14),
            Block.createCuboidShape(13, 2, 13, 14, 7, 14),
            Block.createCuboidShape(13, 2, 2, 14, 7, 3),
            Block.createCuboidShape(2, 2, 2, 3, 7, 3)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        switch (state.get(FACING)) {
            case NORTH:
                return SHAPE_NORTH;
            case SOUTH:
                return SHAPE_SOUTH;
            case WEST:
                return SHAPE_WEST;
            case EAST:
                return SHAPE_EAST;
            default:
                return SHAPE_NORTH;
        }
    }
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }


    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    static {
        FACING = Properties.HORIZONTAL_FACING;
    }
}
