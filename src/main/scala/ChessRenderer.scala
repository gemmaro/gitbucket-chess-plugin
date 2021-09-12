import gitbucket.core.controller.Context
import gitbucket.core.plugin.{RenderRequest, Renderer}
import gitbucket.core.service.RepositoryService.RepositoryInfo
import gitbucket.core.view.helpers.markdown
import play.twirl.api.Html

class ChessRenderer extends Renderer {

  def render(request: RenderRequest): Html = {
    import request._
    Html(toHtml(fileContent)(context))
  }

  def toHtml(fileContent: String)(implicit context: Context): String = {
    // Refer to escapeHtml implementation:
    //   https://github.com/gitbucket/gitbucket/blob/fbc6bd36bd0c574553d52a188a6cc802fa24b9f5/src/main/scala/gitbucket/core/util/StringUtil.scala#L81
    val chessInput = fileContent.trim.stripLineEnd.replace("`", "\\`")

    s"""
       |<div id="board"></div>
       |<script src="https://cdn.jsdelivr.net/npm/@mliebelt/pgn-viewer@1.5.11/lib/pgnv.min.js"></script>
       |<script>
       |  PGNV.pgnView("board", { pgn: `$chessInput` });
       |</script>
       |""".stripMargin
  }

  def shutdown(): Unit = {}

}
