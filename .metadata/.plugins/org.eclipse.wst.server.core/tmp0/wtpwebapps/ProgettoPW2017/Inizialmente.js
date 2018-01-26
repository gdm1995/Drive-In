
/**Rende il sito immediatamente responsive per schermi di dimensione minore o uguale a 680px
 */
function Inizialmente()
{
	var width = $(window).width();
	var height = $(window).height();
	if(width<=680)
	$(window).resizeTo(width-10,height);
}