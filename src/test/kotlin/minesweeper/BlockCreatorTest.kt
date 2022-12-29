package minesweeper

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import minesweeper.domain.Block
import minesweeper.domain.BlockCreator
import minesweeper.domain.Blocks

class BlockCreatorTest : StringSpec({
    "입력 받은 높이와 넓이에 맞게 블록을 가져온다" {
        val height = 3
        val width = 5
        val mineCount = 3

        val creator = BlockCreator(height, width, mineCount)
        val blocks = Blocks(height, width, creator.blocks)

        blocks.blockBoard.size shouldBe height
        blocks.blockBoard[0].size shouldBe width
    }

    "입력 받은 지뢰 개수에 맞게 지뢰를 가져온다" {
        val mineCount = 3
        val creator = BlockCreator(3, 5, mineCount)

        val landMineBlocks = creator.blocks.flatMap { it.filterIsInstance<Block.LandMine>() }

        landMineBlocks.size shouldBe mineCount
    }
})
