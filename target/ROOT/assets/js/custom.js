/**
 * 
 */
$( document ).ready(function() {
	 $("#main-container").html("");
	 $('#idDashboard').click(function () {
		 jQuery("#main-container").load('assets/external-pages/dashboard.jsp');
	  });
	 $('#idUserProfile').click(function () {
		 jQuery("#main-container").load('assets/external-pages/user.jsp');
	 });
	 $('#idTableList').click(function () {
		 jQuery("#main-container").load('assets/external-pages/table.jsp');
	 });
	 $('#idTypography').click(function () {
		 jQuery("#main-container").load('assets/external-pages/typography.jsp');
	 });
	 $('#idIcon').click(function () {
		 jQuery("#main-container").load('assets/external-pages/icon.jsp');
	 });
	 $('#idMap').click(function () {
		 jQuery("#main-container").load('assets/external-pages/map.jsp');
	 });
	 $('#idImageUpload').click(function () {
		 jQuery("#main-container").load('assets/external-pages/image-upload.jsp');
	 });
	 $('#idNotifications').click(function () {
		 jQuery("#main-container").load('assets/external-pages/notification.jsp');
	 });
	 $('#idUpgradeToPro').click(function () {
		 jQuery("#main-container").load('assets/external-pages/upgrade.jsp');
	 });
	
});