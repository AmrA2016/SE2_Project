<?php

define('EMAIL_FOR_REPORTS', '');
define('RECAPTCHA_PRIVATE_KEY', '@privatekey@');
define('FINISH_URI', 'http://');
define('FINISH_ACTION', 'message');
define('FINISH_MESSAGE', 'Thanks for filling out my form!');
define('UPLOAD_ALLOWED_FILE_TYPES', 'doc, docx, xls, csv, txt, rtf, html, zip, jpg, jpeg, png, gif');

define('_DIR_', str_replace('\\', '/', dirname(__FILE__)) . '/');
require_once _DIR_ . '/handler.php';

?>

<?php if (frmd_message()): ?>
<link rel="stylesheet" href="<?php echo dirname($form_path); ?>/formoid-solid-green.css" type="text/css" />
<span class="alert alert-success"><?php echo FINISH_MESSAGE; ?></span>
<?php else: ?>
<!-- Start Formoid form-->
<link rel="stylesheet" href="<?php echo dirname($form_path); ?>/formoid-solid-green.css" type="text/css" />
<script type="text/javascript" src="<?php echo dirname($form_path); ?>/jquery.min.js"></script>
<form class="formoid-solid-green" style="background-color:#FFFFFF;font-size:14px;font-family:'Roboto',Arial,Helvetica,sans-serif;color:#34495E;max-width:480px;min-width:150px" method="post"><div class="title"><h2>Sign-Up as a student</h2></div>
	<div class="element-name<?php frmd_add_class("name"); ?>"><label class="title"></label><span class="nameFirst"><input placeholder="Name First" type="text" size="8" name="name[first]" /><span class="icon-place"></span></span><span class="nameLast"><input placeholder="Name Last" type="text" size="14" name="name[last]" /><span class="icon-place"></span></span></div>
	<div class="element-input<?php frmd_add_class("input"); ?>"><label class="title"></label><div class="item-cont"><input class="large" type="text" name="input" placeholder="Username"/><span class="icon-place"></span></div></div>
	<div class="element-email<?php frmd_add_class("email"); ?>"><label class="title"></label><div class="item-cont"><input class="large" type="email" name="email" value="" placeholder="Email"/><span class="icon-place"></span></div></div>
	<div class="element-password<?php frmd_add_class("password"); ?>"><label class="title"></label><div class="item-cont"><input class="large" type="password" name="password" value="" placeholder="Password"/><span class="icon-place"></span></div></div>
	<div class="element-date<?php frmd_add_class("date"); ?>"><label class="title"></label><div class="item-cont"><input class="large" data-format="yyyy-mm-dd" type="date" name="date" placeholder="Birthday"/><span class="icon-place"></span></div></div>
	<div class="element-radio<?php frmd_add_class("radio"); ?>"><label class="title">Gender</label>		<div class="column column1"><label><input type="radio" name="radio" value="Female" /><span>Female</span></label><label><input type="radio" name="radio" value="Male" /><span>Male</span></label></div><span class="clearfix"></span>
</div>
<div class="submit"><input type="submit" value="Submit"/></div></form><script type="text/javascript" src="<?php echo dirname($form_path); ?>/formoid-solid-green.js"></script>

<!-- Stop Formoid form-->
<?php endif; ?>

<?php frmd_end_form(); ?>