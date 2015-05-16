						<article class="well">
							<div class="row">
							<div class="col-xs-3 col-sm-2 text-center">
								<img src="http://www.gravatar.com/avatar/${entry.author.mailMD5}?s=60&d=retro" class="img-circle" />
							</div>
							<div class="col-xs-9 col-sm-10">
								<p>
									<a href="/shadowsatyr/profile?account=${entry.author.nickname}">${entry.author.nickname}</a>
									<span class="text-success">
										${entry.date}
									</span> 
								</p>
								<p>
									${entry.message}
								<p>
							</div>
							</div>
						</article>