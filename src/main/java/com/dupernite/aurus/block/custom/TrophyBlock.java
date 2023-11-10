package com.dupernite.aurus.block.custom;

import net.minecraft.block.*;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
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
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

import java.util.stream.Stream;

public class TrophyBlock extends HorizontalFacingBlock implements Waterloggable{
    public static final DirectionProperty FACING;
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    public TrophyBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(WATERLOGGED, false));
    }

    private static final VoxelShape SHAPE_NORTH = Stream.of(
            Block.createCuboidShape(5, 0, 5, 11, 1, 11),
            Block.createCuboidShape(6, 1, 6, 10, 2, 10),
            Block.createCuboidShape(7, 2, 7, 9, 7, 9),
            Block.createCuboidShape(6, 7, 6, 10, 8, 10),
            Block.createCuboidShape(10, 8, 6, 11, 14, 10),
            Block.createCuboidShape(12, 10, 7, 13, 13, 9),
            Block.createCuboidShape(3, 10, 7, 4, 13, 9),
            Block.createCuboidShape(11, 9, 7, 12, 10, 9),
            Block.createCuboidShape(11, 12, 7, 12, 13, 9),
            Block.createCuboidShape(4, 12, 7, 5, 13, 9),
            Block.createCuboidShape(4, 9, 7, 5, 10, 9),
            Block.createCuboidShape(5, 8, 6, 6, 14, 10),
            Block.createCuboidShape(6, 8, 5, 10, 14, 6),
            Block.createCuboidShape(6, 8, 10, 10, 14, 11),
            Block.createCuboidShape(5, 9, 10, 6, 13, 11),
            Block.createCuboidShape(10, 9, 5, 11, 13, 6),
            Block.createCuboidShape(5, 9, 5, 6, 13, 6),
            Block.createCuboidShape(10, 9, 10, 11, 13, 11)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape SHAPE_WEST = Stream.of(
            Block.createCuboidShape(5, 0, 5, 11, 1, 11),
            Block.createCuboidShape(6, 1, 6, 10, 2, 10),
            Block.createCuboidShape(7, 2, 7, 9, 7, 9),
            Block.createCuboidShape(6, 7, 6, 10, 8, 10),
            Block.createCuboidShape(6, 8, 5, 10, 14, 6),
            Block.createCuboidShape(7, 10, 3, 9, 13, 4),
            Block.createCuboidShape(7, 10, 12, 9, 13, 13),
            Block.createCuboidShape(7, 9, 4, 9, 10, 5),
            Block.createCuboidShape(7, 12, 4, 9, 13, 5),
            Block.createCuboidShape(7, 12, 11, 9, 13, 12),
            Block.createCuboidShape(7, 9, 11, 9, 10, 12),
            Block.createCuboidShape(6, 8, 10, 10, 14, 11),
            Block.createCuboidShape(5, 8, 6, 6, 14, 10),
            Block.createCuboidShape(10, 8, 6, 11, 14, 10),
            Block.createCuboidShape(10, 9, 10, 11, 13, 11),
            Block.createCuboidShape(5, 9, 5, 6, 13, 6),
            Block.createCuboidShape(5, 9, 10, 6, 13, 11),
            Block.createCuboidShape(10, 9, 5, 11, 13, 6)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape SHAPE_SOUTH = Stream.of(
            Block.createCuboidShape(5, 0, 5, 11, 1, 11),
            Block.createCuboidShape(6, 1, 6, 10, 2, 10),
            Block.createCuboidShape(7, 2, 7, 9, 7, 9),
            Block.createCuboidShape(6, 7, 6, 10, 8, 10),
            Block.createCuboidShape(10, 8, 6, 11, 14, 10),
            Block.createCuboidShape(12, 10, 7, 13, 13, 9),
            Block.createCuboidShape(3, 10, 7, 4, 13, 9),
            Block.createCuboidShape(11, 9, 7, 12, 10, 9),
            Block.createCuboidShape(11, 12, 7, 12, 13, 9),
            Block.createCuboidShape(4, 12, 7, 5, 13, 9),
            Block.createCuboidShape(4, 9, 7, 5, 10, 9),
            Block.createCuboidShape(5, 8, 6, 6, 14, 10),
            Block.createCuboidShape(6, 8, 5, 10, 14, 6),
            Block.createCuboidShape(6, 8, 10, 10, 14, 11),
            Block.createCuboidShape(5, 9, 10, 6, 13, 11),
            Block.createCuboidShape(10, 9, 5, 11, 13, 6),
            Block.createCuboidShape(5, 9, 5, 6, 13, 6),
            Block.createCuboidShape(10, 9, 10, 11, 13, 11)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_EAST = Stream.of(
            Block.createCuboidShape(5, 0, 5, 11, 1, 11),
            Block.createCuboidShape(6, 1, 6, 10, 2, 10),
            Block.createCuboidShape(7, 2, 7, 9, 7, 9),
            Block.createCuboidShape(6, 7, 6, 10, 8, 10),
            Block.createCuboidShape(6, 8, 5, 10, 14, 6),
            Block.createCuboidShape(7, 10, 3, 9, 13, 4),
            Block.createCuboidShape(7, 10, 12, 9, 13, 13),
            Block.createCuboidShape(7, 9, 4, 9, 10, 5),
            Block.createCuboidShape(7, 12, 4, 9, 13, 5),
            Block.createCuboidShape(7, 12, 11, 9, 13, 12),
            Block.createCuboidShape(7, 9, 11, 9, 10, 12),
            Block.createCuboidShape(6, 8, 10, 10, 14, 11),
            Block.createCuboidShape(5, 8, 6, 6, 14, 10),
            Block.createCuboidShape(10, 8, 6, 11, 14, 10),
            Block.createCuboidShape(10, 9, 10, 11, 13, 11),
            Block.createCuboidShape(5, 9, 5, 6, 13, 6),
            Block.createCuboidShape(5, 9, 10, 6, 13, 11),
            Block.createCuboidShape(10, 9, 5, 11, 13, 6)
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
        FluidState fluidState = ctx.getWorld().getFluidState(ctx.getBlockPos());

        return this.getDefaultState()
                .with(FACING, ctx.getHorizontalPlayerFacing().getOpposite())
                .with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER || fluidState.getFluid() == Fluids.FLOWING_WATER);
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
        builder.add(FACING, WATERLOGGED);
    }

    static {
        FACING = Properties.HORIZONTAL_FACING;
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (state.get(WATERLOGGED)) {
            world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    @Override
    public boolean tryFillWithFluid(WorldAccess world, BlockPos pos, BlockState state, FluidState fluidState) {
        if (!state.get(WATERLOGGED) && fluidState.getFluid() == Fluids.WATER) {
            if (!world.isClient()) {
                world.setBlockState(pos, state.with(WATERLOGGED, true), 3);
                world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
            }
            return true;
        } else {
            return Waterloggable.super.tryFillWithFluid(world, pos, state, fluidState);
        }
    }
    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        if (state.get(WATERLOGGED)) {
            return super.canPlaceAt(state, world, pos);
        } else {
            return super.canPlaceAt(state, world, pos) && this.canPlaceBlockOn(world.getBlockState(pos.down()), world, pos.down());
        }
    }

    private boolean canPlaceBlockOn(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isSideSolidFullSquare(world, pos, Direction.UP);
    }
}
