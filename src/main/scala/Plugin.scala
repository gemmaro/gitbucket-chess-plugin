import javax.servlet.ServletContext
import gitbucket.core.plugin.{PluginRegistry}
import gitbucket.core.service.SystemSettingsService
import gitbucket.core.service.SystemSettingsService.SystemSettings
import io.github.gitbucket.solidbase.model.Version

import scala.util.Try

class Plugin extends gitbucket.core.plugin.Plugin {
  override val pluginId: String = "chess"
  override val pluginName: String = "Chess Plugin"
  override val description: String = "Rendering PGN chess files."
  override val versions: List[Version] = List(
    new Version("1.0.0"),
    new Version("1.0.1")
  )

  private[this] var renderer: Option[ChessRenderer] = None

  override def initialize(
      registry: PluginRegistry,
      context: ServletContext,
      settings: SystemSettingsService.SystemSettings
  ): Unit = {
    val test = Try { new ChessRenderer() }
    val chess = test.get
    registry.addRenderer("pgn", chess)
    renderer = Option(chess)
    super.initialize(registry, context, settings)
  }

  override def shutdown(
      registry: PluginRegistry,
      context: ServletContext,
      settings: SystemSettings
  ): Unit = {
    renderer.map(r => r.shutdown())
  }

}
